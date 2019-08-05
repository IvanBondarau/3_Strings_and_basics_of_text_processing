package by.java_tutorial.week3.char_array;

import java.util.Scanner;

public class Task4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[] str = in.nextLine().toCharArray();
		int numberCounter = 0;
		
		for (int i = 0; i < str.length; i++) {
			if (Character.isDigit(str[i])) {
				numberCounter++;
				while (i < str.length && Character.isDigit(str[i])) {
					i++; 
				}
				i--;
			}
		}
		
		System.out.println("Numbers: " + numberCounter);

	}

}
