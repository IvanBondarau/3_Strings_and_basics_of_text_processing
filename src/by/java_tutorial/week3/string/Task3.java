package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		System.out.println("Is palindrome: " + checkPalindrome(s));

	}
	
	private static boolean checkPalindrome(String s) {
		int l = 0;
		int r = s.length() - 1;
		
		while (l < r) {
			if (s.charAt(l) != s.charAt(r)) {
				return false;
			}
			l++;
			r--;
		}
		
		return true;
	}


}
