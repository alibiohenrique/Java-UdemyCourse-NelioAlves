package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTaxServices;
import model.services.RentalServices;

//		Problema exemplo
//		Uma locadora brasileira de carros cobra um valor por hora para locações de até12 horas. 
//		Porém, se a duração da locação ultrapassar 12 horas, a locação serácobrada com base em um valor diário. 
//		Além do valor da locação, é acrescido nopreço o valor do imposto conforme regras do país que, no caso do Brasil, é 20% para valores até 100.00, ou 15% para valores acima de 100.00. 
//		Fazer umprograma que lê os dados da locação (modelo do carro, instante inicial e final dalocação), bem como o valor por hora e o valor diário de locação. 
//		O programadeve então gerar a nota de pagamento (contendo valor da locação, valor doimposto e valor total do pagamento) e informar os dados na tela. 
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
