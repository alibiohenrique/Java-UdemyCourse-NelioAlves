package application;

import java.util.Scanner;

import services.BrazilInterestService;
import services.InterestService;
import services.UsaInterestService;

public class Program {

//	Fazer um programa para ler uma quantia e a duração em meses de umempréstimo. 
//	Informar o valor a ser pago depois de decorrido o prazo doempréstimo, conforme regras de juros do Brasil. 
//	A regra de cálculo dejuros do Brasil é juro composto padrão de 2% ao mês.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Amount: ");
		double amount = sc.nextDouble();
		System.out.print("Months: ");
		int months = sc.nextInt();

		InterestService is = new BrazilInterestService(2.0);
		InterestService is2 = new UsaInterestService(1.0);
		double payment = is.payment(amount, months);
		double payment2 = is2.payment(amount, months);

		System.out.println("Payment after " + months + " months:");
		System.out.println(String.format("%.2f", payment));
		System.out.println(String.format("%.2f", payment2));

		sc.close();
	}

}
