package application;

import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			Integer accountNumber = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String accountHolder = sc.nextLine();
			System.out.print("Initial Balance: ");
			Double accountInitialBalance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double accountWithdrawLimit = sc.nextDouble();
			Account account = new Account(accountNumber, accountHolder, accountInitialBalance, accountWithdrawLimit);

			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			Double withdrawAmount = sc.nextDouble();
			account.withdraw(withdrawAmount);
			System.out.printf("New balance : %.2f%n", account.getBalance());

		}

		catch (DomainException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Unexpexted Error");
		}
		sc.close();
	}

}
