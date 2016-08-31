package actions;

import static org.junit.Assert.*;

import org.junit.Test;

import actions.ReadSportType;
import entities.AmericanFootball;
import entities.Football;
import entities.Tennis;
import factories.SportsFactory;

public class FactorySportsTest {
	String inputFootball = "F.C. Barcelona 3-2 Real Madrid";
	String inputTennis = " Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
	String inputAmericalFootball = " Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";

	@Test
	public void searchTypeFootball() {
		ReadSportType action = new ReadSportType(inputFootball);
		Class<?> type =action.read();
		
	}

	@Test
	public void checkCorrectlyInstanceOfTypeEntityFootball() throws Exception {

		SportsFactory factory = new SportsFactory();
		factory.setType(Football.class);
		Football football = (Football) factory.create();
		assertTrue(football instanceof Football);

	}

	@Test
	public void checkCorrectlyInstanceOfTypeEntityTennis() throws Exception {

		SportsFactory factory = new SportsFactory();
		factory.setType(Tennis.class);
		Tennis football = (Tennis) factory.create();
		assertTrue(football instanceof Tennis);

	}

	@Test
	public void checkCorrectlyInstanceOfTypeEntityAmericanFootball()
			throws Exception {

		SportsFactory factory = new SportsFactory();
		factory.setType(AmericanFootball.class);
		AmericanFootball football = (AmericanFootball) factory.create();
		assertTrue(football instanceof AmericanFootball);

	}
}
