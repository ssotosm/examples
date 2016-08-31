package actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entities.AmericanFootball;
import factories.SportsFactory;

public class AmericanFootballGenerateJsonTest {
	String input = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";

	@Test
	public void generate() throws Exception {

		SportsFactory factory = new SportsFactory();
		factory.setType(AmericanFootball.class);
		AmericanFootball football = (AmericanFootball) factory.create();
		football.generate(input);
		assertEquals("Pittsburgh Steelers", football.getTeamAName());
		assertEquals("Minnesota Vikings", football.getTeamBName());
		assertEquals("3", football.getTeamAScore());
		assertEquals("7", football.getTeamBScore());
		assertEquals("3rd Quarter", football.getCurrentPeriod());

	}
}
