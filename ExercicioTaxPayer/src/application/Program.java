package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxList = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.println("Tax payer #" + i + ": ");
			System.out.print("Individual or company (i/c)? ");
			char check = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			if (check == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				taxList.add(new Individual(name, anualIncome, healthExpenditures));

			} else {

				System.out.print("Number of employees: ");
				Integer numberOfEmployees = sc.nextInt();
				taxList.add(new Company(name, anualIncome, numberOfEmployees));
			}

		}
		double totalTaxes = 0;
		for (TaxPayer tp : taxList) {
			totalTaxes += tp.tax();
			System.out.println(tp);
			
		}
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", totalTaxes));

	}

}
