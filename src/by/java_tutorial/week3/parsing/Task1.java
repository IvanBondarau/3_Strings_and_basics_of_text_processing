package by.java_tutorial.week3.parsing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);

		String s = "";
		
		int n = in.nextInt();
		in.nextLine();

		for (int i = 0; i < n; i++) {
			s += in.nextLine();
			s += "\n";
		}
		
		Text text = new Text(s); 
		text.sortWordsByLetter('a');
		text.printText();

	}

}

class Text {
	
	class Paragraph {
		
		public Paragraph(String paragraph) {
			String[] splitted = paragraph.split("\\.|\\!|\\?");
			sentences = new Sentence[splitted.length];
			
			for (int i = 0; i < splitted.length; i++) {
				sentences[i] = new Sentence(splitted[i]);
			}
		}
		
		private Sentence[] sentences;
		
		public String getParagraph() {
			String res = "";
			
			for (int i = 0; i < sentences.length; i++) {
				res += sentences[i].getSentence();
				res += ".";
			}
			
			return res;
		}
		
		
		public int getNumSentences() {
			return sentences.length;
		}
	}
	
	class ParagraphComparator implements Comparator<Paragraph> {
		@Override
		public int compare(Paragraph a, Paragraph b) {
			return Integer.compare(a.getNumSentences(), b.getNumSentences());
		}
		
	}
	
	class Sentence {
		
		public Sentence(String sentence) { 
			String[] splitted = sentence.split(" |,");
			words = new Word[splitted.length];
			
			for (int i = 0; i < splitted.length; i++) {
				words[i] = new Word(splitted[i]);
			}
		}
		
		private Word[] words; 
		
		public String getSentence() {
			String res = "";
			
			for (int i = 0; i < words.length; i++) {
				res += words[i].getLexeme();
				if (i != words.length - 1) {
					res += " ";
				}
			}
			
			return res;
		}

	}
	
	class WordsComparator implements Comparator<Word> {
		@Override
		public int compare(Word a, Word b) {
			return Integer.compare(a.getLexeme().length(), b.getLexeme().length());
		}
		
	}
	
	class WordByLetterComparator implements Comparator<Word> {
		private char letter;
		
		public WordByLetterComparator(char c) {
			this.letter = c;
		}
		
		@Override
		public int compare(Word a, Word b) {
			if (a.count(letter) < b.count(letter)) {
				return -1;
			}
			
			if (a.count(letter) > b.count(letter)) {
				return 1;
			}
			
			return a.getLexeme().compareTo(b.getLexeme());
		}
		
	}
	
	class Word {
		
		public Word(String lexeme) {
			this.lexeme = lexeme;
		}
		
		private String lexeme;

		public String getLexeme() {
			return lexeme;
		}

		public void setLexeme(String lexeme) {
			this.lexeme = lexeme;
		}
		
		public int count(char c) {
			int res = 0;
			for (int i = 0; i < lexeme.length(); i++) {
				if (lexeme.charAt(i) == c) {
					res++;
				}
			}
			return res;
		}

	}
	
	private String text;
	private Paragraph[] paragraphs;
	
	public Text(String s) {
		text = s;
		
		String[] splitted = text.split("\\r?\\n");
	
		paragraphs = new Paragraph[splitted.length];
		
		for (int i = 0; i < splitted.length; i++) {
			paragraphs[i] = new Paragraph(splitted[i]);
		}
	}
	
	public void printText() {
		System.out.println(paragraphs.length);
		for (int i = 0; i < paragraphs.length; i++) {
			System.out.println(paragraphs[i].getParagraph());
		}
	}
	
	public void sortParagraphs() {
		Arrays.sort(paragraphs, new ParagraphComparator());
	}
	
	public void sortWords() {
		for (Paragraph p: paragraphs) {
			for (Sentence s: p.sentences) {
				Arrays.sort(s.words, new WordsComparator());;
			}
		}
	}
	
	public void sortWordsByLetter(char c) {
		for (Paragraph p: paragraphs) {
			for (Sentence s: p.sentences) {
				Arrays.sort(s.words, new WordByLetterComparator(c));;
			}
		}
	}

	
}


