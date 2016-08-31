package actions;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import javax.print.DocFlavor.READER;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import entities.AmericanFootball;
import entities.Football;
import entities.Tennis;

public class ReadSportTypeTest {
	String inputFootball = "F.C. Barcelona 3-2 Real Madrid";
	String inputTennis = "Anna Karolina Schmiedlova (1) 1 40-Adv 1 (0) *Varvara Lepchenko";
	String inputAmericalFootball = "Pittsburgh Steelers 3-7 Minnesota Vikings 3rd Quarter";
	String inputUndefined = "Not exist sport";
	List<String> resultTeams = new ArrayList<>();

	@Test
	public void checkInputFootballReturnTypeFootball() throws Exception {

		ReadSportType action = new ReadSportType(inputFootball);
		Class<?> type = action.read();
		assertEquals(Football.class, type);

	}

	@Test
	public void checkInputTennisReturnTypeTennis() throws Exception {

		ReadSportType action = new ReadSportType(inputTennis);
		Class<?> type = action.read();
		assertEquals(Tennis.class, type);

	}

	@Test
	public void checkInputAmericanFootballReturnTypeAmericanFootball()
			throws Exception {

		ReadSportType action = new ReadSportType(inputAmericalFootball);
		Class<?> type = action.read();
		assertEquals(AmericanFootball.class, type);

	}

	@Test
	public void checkInputUndefinedSport() {

		ReadSportType action = new ReadSportType(inputUndefined);
		Class<?> type = action.read();
		assertEquals(Object.class, type);
		
	}

}
