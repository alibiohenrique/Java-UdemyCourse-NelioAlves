package application;

import domain.People;

public class Program {

	public static void main(String[] args) {
		People p1 = new People(1, "Carlos da silva ", "carlos@gmail.com");
		People p2 = new People(2, "Isaiah da silva ", "carlos@gmail.com");
		People p3 = new People(3, "Joana da silva ", "joana@gmail.com");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);

	}

}
