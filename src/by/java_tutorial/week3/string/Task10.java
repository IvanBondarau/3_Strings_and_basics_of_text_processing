package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task10 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		int counter = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.' || s.charAt(i) == '!' || s.charAt(i) == '?') {
				counter++;
			}
		}
		
		System.out.println(counter);

	}

}
