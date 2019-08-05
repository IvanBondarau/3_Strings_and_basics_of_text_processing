package by.java_tutorial.week3.char_array;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter string: ");
		char[] inStr = in.nextLine().toCharArray(); 
		
		char[] outStr = new char[inStr.length*2];
		int outStrPointer = 0;
		
		final char[] word = {'w', 'o', 'r', 'd'};
		
		int i = 0;
		
		for (i = 0; i < inStr.length - 3; i++) {

			if (Arrays.equals(Arrays.copyOfRange(inStr, i, i + 4), word)) {
				outStr[outStrPointer++] = 'l';
				outStr[outStrPointer++] = 'e';
				outStr[outStrPointer++] = 't';
				outStr[outStrPointer++] = 't';
				outStr[outStrPointer++] = 'e';
				outStr[outStrPointer++] = 'r';
				
				i += 3;
			} else {
				outStr[outStrPointer++] = inStr[i];
			}
		}
		
		for (; i < inStr.length; i++) {
			outStr[outStrPointer++] = inStr[i];
		}
		
		System.out.println(outStr);

	}

}
