package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

//	A empresa utiliza um servi�o de pagamento online para realizar o pagamento das parcelas.
//	Os servi�os de pagamento online tipicamente cobram um juro mensal, bem como uma taxapor pagamento. 
//	Por enquanto, o servi�o contratado pela empresa � o do Paypal, que aplicajuros simples de 1% a cada parcela, mais uma taxa de pagamento de 2%.
//	Fazer um programa para ler os dados de um contrato (n�mero do contrato, data do contrato,e valor total do contrato). 
//	Em seguida, o programa deve ler o n�mero de meses paraparcelamento do contrato, e da� gerar os registros de parcelas 
//	a serem pagas (data e valor), sendo a primeira parcela a ser paga um m�s ap�s a data do contrato, a segunda parcela dois meses ap�s o contrato e 
//	assim por diante. 
//	Mostrar os dados das parcelas na tela.

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.println("Enter with contracts data");
		System.out.print("Contract number: ");
		int number = sc.nextInt();
		System.out.print("Data (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), fmt);
		System.out.print("Contract value: ");
		double contractValue = sc.nextDouble();

		Contract contract = new Contract(number, date, contractValue);

		System.out.print("Enter the number of installments: ");
		int installments = sc.nextInt();

		ContractService contractService = new ContractService(new PaypalService());
		contractService.processContract(contract, installments);

		System.out.println("Installments:");
		for (Installment inst : contract.getInstallments()) {
			System.out.println(inst);

		}

		sc.close();
	}

}
