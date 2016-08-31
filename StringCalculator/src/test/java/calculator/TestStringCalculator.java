package calculator;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

public class TestStringCalculator {

	@Test
	public void addStringNumbersEmpty() {
		String listNumber = "";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(0), resultCalculator);

	}

	@Test
	public void addOneStringNumbers() {
		String listNumber = "5";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(5), resultCalculator);

	}

	@Test
	public void addTwoStringNumbers() {
		String listNumber = "5,6";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(11), resultCalculator);

	}

	@Test
	public void addListStringNumbers() {
		String listNumber = "5,2,1,3";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(11), resultCalculator);

	}

	@Test
	public void addListStringNumbersStartWithDelimiter() {
		String listNumber = "//, 5,2,1,3";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(11), resultCalculator);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void getDelimiterSomeChars() {
		String listNumber = "//,*. 5,2,1,3";
		StringCalculator calculator = new StringCalculator(listNumber);
		Class classStringCalculator = calculator.getClass();	
		Method method = null;
		try {
			method = classStringCalculator.getDeclaredMethod("getDelimiter",null);
		} catch (NoSuchMethodException | SecurityException e) {
			fail("No ha encontrado el método privado");
		}
		method.setAccessible(true);

		try {
			String delimiter = (String) method.invoke(calculator, null);
			assertEquals(",*.", delimiter);

		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			fail("No ha conseguido invocar el método");
		}

	}
	

	@Test
	public void addListStringNumbersStartWithDelimiterExceptionNegativeNumbers() {
		String listNumber = "//, 5,2,1,-3";
		StringCalculator calculator = new StringCalculator(listNumber);

		try {
			calculator.add();
			fail("Debería producir excepción");
		} catch (RuntimeException e) {
			assertEquals(e.getMessage(),
					"Los números negativos no son permitidos");
		}

	}

	@Test
	public void addListStringNumbersIgnoreOneThousandNumbers() {
		String listNumber = "//, 5,2,1000,3";
		StringCalculator calculator = new StringCalculator(listNumber);
		Integer resultCalculator = calculator.add();
		assertEquals(Integer.valueOf(10), resultCalculator);

	}
	
}
