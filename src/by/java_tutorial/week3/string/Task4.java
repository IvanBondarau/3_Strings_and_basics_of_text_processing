package by.java_tutorial.week3.string;

public class Task4 {

	public static void main(String[] args) {

		String s = "информатика";
		String res = "";

		res = res.concat(s.substring(7, 8));
		res = res.concat(s.substring(3, 5));
		res = res.concat(s.substring(7, 8));

		System.out.println(res);

	}

}