package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();
		int x;
		System.out.print("Enter the number of employees: ");
		x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.print("Outsourced (y/n)? ");
			char checkEmp = sc.next().charAt(0);

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.next();
			System.out.print("Hours: ");
			Integer hours = sc.nextInt();
			System.out.print("Value per hour: ");
			Double valuePerHour = sc.nextDouble();

			if (checkEmp == 'y') {
				System.out.print("Additional charge: ");
				double aditionalCharge = sc.nextDouble();
				list.add(new OutsourcedEmployee(name, hours, valuePerHour, aditionalCharge));

			} else
				list.add(new Employee(name, hours, valuePerHour));

		}
		System.out.println("Payments: ");
		for (Employee emp : list) {
			System.out.println(emp.getName() + " - $ " + String.format("%.2f", emp.payment()));
		}
		sc.close();
	}
}