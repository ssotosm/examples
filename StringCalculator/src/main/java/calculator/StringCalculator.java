package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StringCalculator implements IStringCalculator {

	private String listNumbersString;

	public StringCalculator(String listNumbersString) {
		this.listNumbersString = listNumbersString;
	}

	@Override
	public Integer add() {
		return listNumbersString.isEmpty() ? 0 : addNotEmpty();
	}

	/**
	 * Add numbers if list not is empty
	 * 
	 * @return
	 */
	private Integer addNotEmpty() {
		Integer resultAddNumber = 0;
		String delimiter = getDelimiter();

		resultAddNumber = delimiter != null ? addNumbersPossibleNegatives(delimiter)
				: addNumbersNormalOperation(listNumbersString);

		return resultAddNumber;
	}

	/**
	 * Function to get delimiter of list numbers if startsWith //
	 * 
	 * @return
	 */
	private String getDelimiter() {
		if (listNumbersString.startsWith("//")) {

			// buscamos el delimitador hasta el espacio en blanco
			String[] listNumbersWithDelimiter = listNumbersString.split(" ");
			String delimiter = listNumbersWithDelimiter[0];

			// eliminamos de la lista el delimitador
			listNumbersString = listNumbersString.substring(delimiter.length());

			// quitamos los carácteres "//" del delimitador
			delimiter = delimiter.substring(2, delimiter.length());

			return delimiter;
		}
		return null;
	}

	/**
	 * Function to add all numbers to list but if any number is negative
	 * produces exception
	 * 
	 * @param delimiter
	 * @return
	 */
	private Integer addNumbersPossibleNegatives(String delimiter) {
		String[] arrayListNumbersString = null;

		if (delimiter != null) {
			arrayListNumbersString = listNumbersString.split(delimiter);
		}

		existAnyNumberNegative(arrayListNumbersString);

		Integer result = 0;
		for (int i = 0; i < arrayListNumbersString.length; i++) {
			result = addNumbersNormalOperation(arrayListNumbersString[i])
					+ result;
		}

		// Stream.of(arrayListNumbersString).forEach(number->number = number+
		// addNumbersNormalOperation(number));

		return result;
	}

	/**
	 * Check if exist any number negative in the array
	 * 
	 * @param arrayListNumbersString
	 * @return
	 */
	private void existAnyNumberNegative(String[] arrayListNumbersString) {

		Boolean existNegativeNumber = Stream.of(arrayListNumbersString)
				.map(String::trim).anyMatch(s -> s.startsWith("-"));
		if (existNegativeNumber) {
			throw new RuntimeException(
					"Los números negativos no son permitidos");
		}
	}

	/**
	 * Function to add all numbers to list
	 * 
	 * @return
	 */
	private Integer addNumbersNormalOperation(String listNumbersString) {
		return null;

		// String aux=listNumbersString
		// .chars()
		// .filter(characterNotNumber -> Character
		// .isDigit(characterNotNumber))
		// .map(Character::getNumericValue).filter(number->number<1000).collect((Supplier<R>)
		// Collectors.toList());
		//
		//
		//
		// return listNumbersString
		// .chars()
		// .filter(characterNotNumber -> Character
		// .isDigit(characterNotNumber))
		// .map(Character::getNumericValue)
		// .filter(number->number<1000)
		// .sum();
		// }
	}
}
