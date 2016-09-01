package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import fermatnumber.FermatNumber;

public class FermatNumberTest {

	FermatNumber fermat;

	@Before
	public void setUp() {
		fermat = FermatNumber.getInstance();
	}

	@Test(expected = RuntimeException.class)
	public void notValidNumber() {
		fermat.calculate((double) 0);
	}

	@Test
	public void sameInstanceClass() {
		FermatNumber fermat = FermatNumber.getInstance();
		assertEquals(this.fermat, fermat);

	}

	@Test
	public void calculateNumberFermatOne() {
		Double numberFermat = fermat.calculate((double) 1);
		assertEquals(Double.valueOf(5), numberFermat);

	}
	@Test
	public void calculateNumberFermatTwo() {
		Double numberFermat = fermat.calculate((double) 2);
		assertEquals(Double.valueOf(17), numberFermat);
	}
	
}
