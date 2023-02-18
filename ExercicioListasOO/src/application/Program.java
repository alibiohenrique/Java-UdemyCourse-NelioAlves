
package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;

//Make a program to read an integer N and then the data (id, name and salary) of No employees. There must be no repetition of id.
//Then, increase the salary of a given employee by X percent.
//For this, the program must read an id and the value X. 
//If the informed id does not exist, show a message and abort the operation. At the end, show the updated list of employees, as examples.
//Remember to apply the encapsulation technique to not allow earnings to be changed freely. A salary can only be increased on the basis of a
//increase by given percentage.

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Employee> employee = new ArrayList<>();

		int x;

		System.out.print("How many employees will be registred? ");
		x = sc.nextInt();

		for (int i = 0; i < x; i++) {
			System.out.println();
			System.out.println("Employee #" + (i + 1) + ": ");
			System.out.print("Id:");
			int id = sc.nextInt();
			while (hasId(employee, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name:");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary:");
			Double salary = sc.nextDouble();

			employee.add(new Employee(id, name, salary));
		}
		System.out.println();
		System.out.print("Enter the employee id that will have salary increase: ");
		int id = sc.nextInt();
		Employee emp = employee.stream().filter(y -> y.getId() == id).findFirst().orElse(null);
		if (emp == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percentage = sc.nextDouble();
			emp.increaseSalary(percentage);
		}

		System.out.println("List of employees: ");
		for (Employee listOfEmployee : employee) {
			System.out.println(listOfEmployee);

		}
		sc.close();
	}

	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;

	}

}