package actions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import entities.AmericanFootball;
import entities.Football;
import entities.Tennis;

public class ReadSportType {
	private String input = "";
	private List<String> resultTeams = new ArrayList<>();

	public ReadSportType(String input) {
		this.input = input;
	}

	public Class<?> read() {

		getTeams(this.input);

		Boolean americanFootball = isAmericanFootball(resultTeams);

		if (americanFootball)
			return AmericanFootball.class;

		Boolean tennis = isTennis(resultTeams);

		if (tennis)
			return Tennis.class;

		Boolean football = isFootball(resultTeams);
		if (football)
			return Football.class;

		return Object.class;
	}

	private void getTeams(String input) {
		String[] teams = input.split("-");
		Stream.of(teams).forEach(team -> resultTeams.add(team));

	}

	private Boolean isFootball(List<String> teams) {
		long countMatches = countReferencesNumberByTeamInput(teams);
		return countMatches == 2 ? true : false;
	}

	private Boolean isTennis(List<String> teams) {
		long countMatches = countReferencesNumberByTeamInput(teams);
		return countMatches >= 4 ? true : false;
	}

	private Boolean isAmericanFootball(List<String> teams) {
		return teams.stream().anyMatch(team -> team.contains("Quarter"));

	}

	private long countReferencesNumberByTeamInput(List<String> teams) {
		long countMatches = 0;
		Pattern pattern = Pattern.compile("\\d+");

		for (String team : teams) {

			Matcher matcher = pattern.matcher(team);
			while (matcher.find()) {
				countMatches++;
			}

		}
		return countMatches;
	}

}
