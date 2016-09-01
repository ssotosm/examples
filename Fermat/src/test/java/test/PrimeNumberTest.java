package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fermatnumber.NumbersUtils;

public class PrimeNumberTest {

	NumbersUtils utils;

	@Before
	public void setUp() {
		utils = new NumbersUtils();
	}

	@Test(expected = RuntimeException.class)
	public void notValidNumber() {
		utils.isPrimeNumber(0);
	}

	@Test
	public void isPrimeNumberOne() {

		Boolean isPrime = utils.isPrimeNumber(1);
		assertTrue(isPrime);

	}

	@Test
	public void isPrimeNumberTwo() {

		Boolean isPrime = utils.isPrimeNumber(2);
		assertTrue(isPrime);

	}

	@Test
	public void notIsPrimeNumber() {

		Boolean isPrime = utils.isPrimeNumber(4);
		assertFalse(isPrime);

	}

	@Test
	public void quantityOfPrimesNumberTo100FirstElements() {
		int countPrimes = 0;
		int countNotPrimes = 0;

		for (int i = 1; i <= 100; i++) {
			if (utils.isPrimeNumber(i)) {
				countPrimes++;
			} else {
				countNotPrimes++;
			}
		}
		System.out.println("cantidad de numeros primos de 0-100 :"
				+ countPrimes);
		System.out.println("cantidad de numeros no primos de 0-100 :"
				+ countNotPrimes);

		utils.printListNumbers();
	}
	@Test
	public void quantityOfPrimesNumberTo200FirstElements() {
		int countPrimes = 0;
		int countNotPrimes = 0;

		for (int i = 1; i <= 200; i++) {
			if (utils.isPrimeNumber(i)) {
				countPrimes++;
			} else {
				countNotPrimes++;
			}
		}
		System.out.println("cantidad de numeros primos de 0-100 :"
				+ countPrimes);
		System.out.println("cantidad de numeros no primos de 0-100 :"
				+ countNotPrimes);

		utils.printListNumbers();
	}
}
