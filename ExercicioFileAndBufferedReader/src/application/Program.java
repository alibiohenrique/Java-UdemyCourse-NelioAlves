package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class Program {
	
//	Fazer um programa para ler o caminho de um arquivo .csv
//	contendo os dados de itens vendidos. Cada item possui um
//	nome, preço unitário e quantidade, separados por vírgula. Você
//	deve gerar um novo arquivo chamado "summary.csv", localizado
//	em uma subpasta chamada "out" a partir da pasta original do
//	arquivo de origem, contendo apenas o nome e o valor total para
//	aquele item (preço unitário multiplicado pela quantidade),
//	conforme exemplo.

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		List<Product> productList = new ArrayList<>();

		System.out.print("Enter file path: ");
		String sourceFileStr = sc.nextLine();
		File sourceFile = new File(sourceFileStr);
		String sourceFoulderStr = sourceFile.getParent();

		boolean sucess = new File(sourceFoulderStr + "\\out").mkdir();
		String targetFileStr = sourceFoulderStr + "\\out\\sumary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String [] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);
				
				productList.add(new Product(name, price, quantity));
				
				itemCsv = br.readLine();
			}
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {
				for (Product item : productList) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
					
				}
				System.out.println(targetFileStr + "Created");
					
				
			}
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
				
			}
			

		} catch (IOException e) {
			System.out.println("Error writing file:  " + e.getMessage());

		}

		sc.close();

	}

}
