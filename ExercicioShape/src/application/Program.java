package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x;
		List<Shape> shapeList = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.println("Shape #" + i + " data: ");
			System.out.print("Rectangle or Circle (r/c)? ");
			char shape = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if (shape == 'r') {
				System.out.print("Width: ");
				Double width = sc.nextDouble();
				System.out.print("Height: ");
				Double height = sc.nextDouble();
				shapeList.add(new Rectangle(color, width, height));
			} else {
				System.out.print("Radius: ");
				Double radius = sc.nextDouble();
				shapeList.add(new Circle(color, radius));
			}
		}
		System.out.println();
		System.out.println("SHAPE AREAS");
		for (Shape sh : shapeList) {
			System.out.printf(String.format("%.2f%n", sh.area()));
		}
		sc.close();
	}

}
