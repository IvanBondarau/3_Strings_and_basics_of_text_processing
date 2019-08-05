package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task8 {
	
	private static int l = 0;
	private static int r = 0;
	
	private static String nextWord(String s) {
		l = r;
		while (l < s.length() && s.charAt(l) == ' ') {
			l++;
		}
		
		r = l;
		while (r < s.length() && s.charAt(r) != ' ') {
			r++;
		}
		
		return s.substring(l, r);
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();

		String word = "";
		String maxWord = "";
		
		while ((word = nextWord(s)).length() > 0) {
			if (maxWord.length() < word.length()) {
				maxWord = word;
			}
		}
		
		System.out.println(maxWord);
		
		
		

	}

}
