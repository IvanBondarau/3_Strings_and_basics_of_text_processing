package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task1 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		int maxSpaces = 0;
		int spaceCounter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				spaceCounter++;
			} else {
				spaceCounter = 0;
			}
			
			maxSpaces = Math.max(maxSpaces, spaceCounter);
			
		}
		
		System.out.println(maxSpaces);
		
	}
}
