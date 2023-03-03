package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<Integer> courseA = new HashSet<>();
		Set<Integer> courseB = new HashSet<>();
		Set<Integer> courseC = new HashSet<>();

		System.out.print("How many students in Course A: ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int userCode = sc.nextInt();
			courseA.add(userCode);
		}
		System.out.print("How many students in Course B: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int userCode = sc.nextInt();
			courseB.add(userCode);
		}
		System.out.print("How many students in Course C: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int userCode = sc.nextInt();
			courseC.add(userCode);
		}

		Set<Integer> totalUsers = new HashSet<Integer>(courseA);
		totalUsers.addAll(courseC);
		totalUsers.addAll(courseB);

		System.out.println("Total students: " + totalUsers.size());

		sc.close();

	}

}
