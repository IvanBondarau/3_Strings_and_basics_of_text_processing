package by.java_tutorial.week3.char_array;

import java.util.Scanner;

public class Task1 {

	private static char[] translateVarName(char[] varName) {
		char[] translatedVarName = new char[100];
		int translatedVarNamePointer = 0;

		for (int varNamePointer = 0; varNamePointer < varName.length; varNamePointer++) {
			if (Character.isLetter(varName[varNamePointer])
					&& Character.isUpperCase(varName[varNamePointer])) {
				translatedVarName[translatedVarNamePointer++] = '_';
				translatedVarName[translatedVarNamePointer++] = Character.toLowerCase(varName[varNamePointer]);
			} else {
				translatedVarName[translatedVarNamePointer++] = varName[varNamePointer];
			}
		}

		char[] res = new char[translatedVarNamePointer];
		for (int i = 0; i < res.length; i++) {
			res[i] = translatedVarName[i];
		}

		return res;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter array size: ");

		int arraySize = in.nextInt();
		char[][] varArray = new char[arraySize][];

		System.out.println("Enter variables names (line by line): ");

		in.nextLine(); // Skip empty line

		for (int i = 0; i < varArray.length; i++) {
			varArray[i] = in.nextLine().toCharArray();
		}

		for (int curVar = 0; curVar < varArray.length; curVar++) {
			varArray[curVar] = translateVarName(varArray[curVar]);
		}

		System.out.println("Result: ");
		for (int i = 0; i < varArray.length; i++) {
			System.out.println(varArray[i]);
		}

	}

}
