package by.java_tutorial.week3.string;

import java.util.Scanner;

public class Task7 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String s = in.nextLine();
		
		StringBuilder res = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (!(s.charAt(i) == ' ' 
					|| (i > 0 && s.charAt(i) == s.charAt(i - 1)))) {
				res.append(s.charAt(i));
			}
		}
		
		System.out.println(new String(res));
		
	}

}
