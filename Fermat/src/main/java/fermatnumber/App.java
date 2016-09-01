package fermatnumber;

import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		FermatNumber fermat = FermatNumber.getInstance();
		NumbersUtils prime = new NumbersUtils();

		// calculate number fermat
		Scanner in = new Scanner(System.in);
		System.out.println("---- NUMEROS DE FERMAT ----");

		System.out
				.println("¿Quieres calcular el número de fermat de un número?");
		
		String answer=in.next();
		if (answer.equals("si")) {
			
			System.out.println("Introduce el número :");
			Double number = in.nextDouble();
			double fermatNumber = fermat.calculate(number);
			System.out.println("El número de fermat es : " + fermatNumber);
			boolean isPrime = prime.isPrimeNumber(fermatNumber);
			System.out.println("¿Es un número primo? : " + isPrime);
			in.close();
			System.out.println("Terminado...");
			
		} else if (answer.equals("no")) {
			
			System.out.println("Introduce la cantidad de números :");
			Double number = in.nextDouble();
			List<Double> listNumbers = fermat.calculateN(number);
			fermat.printListNumbers(listNumbers);
			in.close();
			System.out.println("Terminado...");
			
		} else {
			System.out.printf("Las respuestas posibles son si/no");
			in.close();
			System.out.println("Terminado...");
		}

	}

}
