package actions;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import entities.AmericanFootball;
import entities.ScoreBoard;
import entities.Tennis;
import factories.SportsFactory;

public class TennisGenerateJsonTest {

	String inputTennis = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";

	@Test
	public void generate() throws Exception {
		SportsFactory factory = new SportsFactory();
		factory.setType(Tennis.class);
		Tennis tennis = (Tennis) factory.create();
		tennis.generate(inputTennis);
		assertEquals("Anna Karolina Schmiedlova", tennis.getTeamAName());
		assertEquals(" Varvara Lepchenko", tennis.getTeamBName());
		assertEquals("40", tennis.getTeamAScore());
		assertEquals("Adv", tennis.getTeamBScore());
		assertEquals("1", tennis.getTeamAGames());
		assertEquals("1", tennis.getTeamBGames());
		assertTrue(tennis.isTeamBServing());
		assertNotNull(tennis.getScoreBoard());
		ScoreBoard scoreboard=tennis.getScoreBoard();
		Map<String, String> elements = scoreboard.getElements();
		assertEquals(3,scoreboard.getElements().size());
		String title=elements.get("title");
		String teamAScore=elements.get("teamAScore");
		String teamBScore=elements.get("teamBScore");
		assertEquals("sets", title);
		assertEquals("1", teamAScore);
		assertEquals("0",teamBScore);

	}
}
