package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task9 {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		int upperCounter = 0;
		int lowerCounter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				upperCounter++;
			}
			if (Character.isLowerCase(s.charAt(i))) {
				lowerCounter++;
			}
		}
		
		System.out.println("Lower case letters: " + lowerCounter);
		System.out.println("Upper case letters: " + upperCounter);

	}
}
