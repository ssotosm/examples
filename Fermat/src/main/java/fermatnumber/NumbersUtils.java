package fermatnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersUtils {

	private List<String> listPrimes;

	public NumbersUtils() {
		this.listPrimes = new ArrayList<>();
	}

	public Boolean isPrimeNumber(double fermatNumber) {
		
		if (!(fermatNumber > 0)) {
			throw new RuntimeException("El numero tiene que ser mayor que 0");
		}
		int aux = 0;
		for (int i = 1; i < (fermatNumber + 1); i++) {
			if (fermatNumber % i == 0)
				aux++;
		}

		boolean isPrime;
		
		if (aux > 2) {
			isPrime = false;
		} else {
			isPrime = true;
		}
		if (isPrime) {
			listPrimes.add(String.valueOf(fermatNumber));
		}

		return isPrime;

	}

	public void printListNumbers() {
		String primes = this.listPrimes.stream().collect(
				Collectors.joining(", "));
		System.out.println(primes);
	}

}
