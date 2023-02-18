package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProducts;
import entities.Product;
import entities.UsedProducts;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Product> productList = new ArrayList<>();

		int x;
		System.out.print("Enter the number of products: ");
		x = sc.nextInt();

		for (int i = 1; i <= x; i++) {
			System.out.print("Common, used or imported (c/u/i)? ");
			char checkStatus = sc.next().charAt(0);

			if (checkStatus == 'c') {
				System.out.print("Name: ");
				String name = sc.next();
				System.out.print("Price: ");
				Double price = sc.nextDouble();
				productList.add(new Product(name, price));
			} else if (checkStatus == 'u') {
				System.out.print("Name: ");
				String name1 = sc.next();
				System.out.print("Price: ");
				Double price1 = sc.nextDouble();
				System.out.print("Manufacture date (DD/MM/YYYY) ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

				productList.add(new UsedProducts(name1, price1, date));
			} else if (checkStatus == 'i') {
				System.out.print("Name: ");
				String name2 = sc.next();
				System.out.print("Price: ");
				Double price2 = sc.nextDouble();
				System.out.print("Custom fee: ");
				Double customFee = sc.nextDouble();
				productList.add(new ImportedProducts(name2, price2, customFee));
			}

		}

		for (Product prod : productList) {
			System.out.println(prod.priceTag());

		}

		sc.close();

	}

}
