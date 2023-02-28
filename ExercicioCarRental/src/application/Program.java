package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

//		Problema exemplo
//		Uma locadora brasileira de carros cobra um valor por hora para loca��es de at�12 horas. 
//		Por�m, se a dura��o da loca��o ultrapassar 12 horas, a loca��o ser�cobrada com base em um valor di�rio. 
//		Al�m do valor da loca��o, � acrescido nopre�o o valor do imposto conforme regras do pa�s que, no caso do Brasil, � 20% para valores at� 100.00, ou 15% para valores acima de 100.00. 
//		Fazer umprograma que l� os dados da loca��o (modelo do carro, instante inicial e final daloca��o), bem como o valor por hora e o valor di�rio de loca��o. 
//		O programadeve ent�o gerar a nota de pagamento (contendo valor da loca��o, valor doimposto e valor total do pagamento) e informar os dados na tela. 
//		
public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		System.out.println("Enter with rent data:");
		System.out.print("Car Model: ");
		String carModel = sc.nextLine();
		System.out.print("Start rent date (dd/MM/yyyy HH:mm): ");
		LocalDateTime startDate = LocalDateTime.parse(sc.nextLine(), fmt);
		System.out.print("Return rent date(dd/MM/yyyy HH:mm): ");
		LocalDateTime returnDate = LocalDateTime.parse(sc.nextLine(), fmt);

		CarRental carRt = new CarRental(startDate, returnDate, new Vehicle(carModel));
		System.out.print("Enter with price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter with price per day: ");
		double pricePerDay = sc.nextDouble();

		RentalServices rentalSv = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxServices());

		rentalSv.processInvoice(carRt);

		System.out.println("FATURA:");
		System.out.println("Pagamento basico: " + String.format("%.2f", carRt.getInvoice().getBasicPayment()));
		System.out.println("Imposto: " + String.format("%.2f", carRt.getInvoice().getTax()));
		System.out.println("Pagamento total: " + String.format("%.2f", carRt.getInvoice().getTotalPayment()));

		sc.close();

	}

}
