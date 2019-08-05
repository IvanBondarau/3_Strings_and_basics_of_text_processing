package by.java_tutorial.week3.char_array;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[] str = in.nextLine().toCharArray();
		int digitCounter = 0;
		
		for (char c: str) {
			digitCounter += Character.isDigit(c) ? 1 : 0;  
		}
		
		System.out.println("Digits: " + digitCounter);

	}

}
