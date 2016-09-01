package fermatnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FermatNumber {

	private static FermatNumber instance = null;

	private FermatNumber() {
	}

	public static synchronized FermatNumber getInstance() {
		if (instance == null)
			instance = new FermatNumber();
		return instance;
	}

	public double calculate(Double number) {

		if (!(number > 0)) {
			throw new RuntimeException("El numero tiene que ser mayor que 0");
		}
		// 2^2^n +1. Fermat(1) = 5, Fermat(2) = 17
		return Math.pow((double) 2, Math.pow((double) 2, (double) number)) + 1;

	}

	public List<Double> calculateN(Double number) {

		List<Double> numbers = new ArrayList<>();
		for (double i = 1; i < number; i++) {
			numbers.add(calculate(i));
		}

		return numbers;
	}

	public void printListNumbers(List<Double> numbers) {
		String primes = numbers.stream().map(i -> i.toString())
				.collect(Collectors.joining(", "));
		System.out.println(primes);
	}

}
