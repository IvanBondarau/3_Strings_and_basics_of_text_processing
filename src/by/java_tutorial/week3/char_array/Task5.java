package by.java_tutorial.week3.char_array;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		char[] str = in.nextLine().toCharArray();
		int leadingSpaces = 0;
		int thrillingSpaces = str.length - 1;
		
		while (str[leadingSpaces] == ' ') {
			leadingSpaces++;
		}
		
		while (str[thrillingSpaces] == ' ') {
			thrillingSpaces--;
		}
		
		//System.out.println("Leading spaces: " + leadingSpaces);
		//System.out.println("Thrilling spaces: " + thrillingSpaces);
		
		str = Arrays.copyOfRange(str, leadingSpaces, thrillingSpaces + 1);
		char[] outStr = new char[str.length*2];
		int outStrPointer = 0;
		
		
		for (int i = 0; i < str.length; i++) {
			outStr[outStrPointer++] = str[i];
			if (str[i] == ' ') {
				while (str[i] == ' ') {
					i++;
				}
				i--;
			}
				
		}
		
		char[] res = Arrays.copyOfRange(outStr, 0, outStrPointer);
		
		System.out.println("\"" + new String(res) + "\"");
	}
}
