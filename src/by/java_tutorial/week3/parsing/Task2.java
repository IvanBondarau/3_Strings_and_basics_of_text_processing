package by.java_tutorial.week3.parsing;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {

    private static String text;

    private static Pattern openingTag = Pattern.compile("<.+?>");
    private static Pattern tagName = Pattern.compile("([a-z]+)( |>)");
    private static Pattern param = Pattern.compile("([a-z0-9]+) *= *\"([a-z0-9]+)\"");

    private static void findAll(String text, int nesting) {

        String indent = "";
        for (int i = 0; i < nesting; i++) {
            indent += "   ";
        }

        Matcher openTagMatcher = openingTag.matcher(text);
        Matcher wordMatcher = tagName.matcher(text);

        int position = 0;
        boolean subtagsFound = false;
        while (openTagMatcher.find(position)) {

            subtagsFound = true;

            if (wordMatcher.find(openTagMatcher.start())) {
                String tagName = wordMatcher.group().substring(0, wordMatcher.group().length() - 1);

                Pattern closingTag = Pattern.compile("</" + tagName + ">");

                Matcher closingTagMatcher = closingTag.matcher(text);

                if (closingTagMatcher.find(openTagMatcher.end())) {
                    System.out.println(indent + "Tag: " + tagName + " ");

                    if (!wordMatcher.group().endsWith(">")) {
                        Matcher paramMatcher = param.matcher(text);
                        int pos = wordMatcher.end();
                        while (paramMatcher.find(pos) && paramMatcher.end() < openTagMatcher.end()) {
                            System.out.println(indent + paramMatcher.group());
                            pos = paramMatcher.end();
                        }
                    }

                    findAll(text.substring(openTagMatcher.end(), closingTagMatcher.start()), nesting + 1);
                    position = closingTagMatcher.end();
                } else {
                    System.out.println(indent + openTagMatcher.group() + " - Invalid tag");
                }
            } else {
                System.out.println(indent + openTagMatcher.group() + " - Invalid tag");
                position = openTagMatcher.end();
            }


        }

        if (!subtagsFound) {
            System.out.println(indent + text);
        }
    }

    public static void main(String[] args) {
        try {
            text = new String(Files.readAllBytes(Paths.get("test.xml")));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
        findAll(text, 0);

    }
}
