package actions;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import entities.Football;
import factories.SportsFactory;

public class FootballGenerateJsonTest {
	String input = "F.C. Barcelona 3-2 Real Madrid";
	

	@Test
	public void generate() throws Exception {
		SportsFactory factory = new SportsFactory();
		factory.setType(Football.class);
		Football football = (Football) factory.create();
		football.generate(input);
		assertEquals("F.C. Barcelona", football.getTeamAName());
		assertEquals("Real Madrid", football.getTeamBName());
		assertEquals("3", football.getTeamAScore());
		assertEquals("2", football.getTeamBScore());

	}
}
