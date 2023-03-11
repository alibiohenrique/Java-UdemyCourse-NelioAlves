package application;

import java.util.Date;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Department dpt = new Department(1,  "books");
		Seller seller = new Seller(321, "Jose Carlos", "jose@carlos.com", new Date(), 3500.00, dpt);
		System.out.println(dpt);
		System.out.println(seller);

	}

}
