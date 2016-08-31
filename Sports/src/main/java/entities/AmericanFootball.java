package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AmericanFootball extends Entity {

	private String currentPeriod;

	public String getCurrentPeriod() {
		return currentPeriod;
	}

	public void setCurrentPeriod(String currentPeriod) {
		this.currentPeriod = currentPeriod;
	}

	@Override
	public void generate(String input) {
		String inputWithoutPeriod = generateCurrentPeriodAndEliminateFromInput(input);

		String[] teams = inputWithoutPeriod.split("-");
		List<String> resultTeams = new ArrayList<>();
		Stream.of(teams).forEach(team -> resultTeams.add(team));

		generateTeamA(teams);

		generateTeamB(teams);

	}

	private void generateTeamA(String[] teams) {
		String teamA = teams[0];
		String[] partsTeamA = teamA.split(" ");

		String nameTeamA = getNameTeam(partsTeamA);
		String scoreTeamA = getScoreTeam(partsTeamA);
		this.setTeamAName(nameTeamA);
		this.setTeamAScore(scoreTeamA);

	}

	private void generateTeamB(String[] teams) {
		String teamB = teams[1];
		String[] partsTeamB = teamB.split(" ");

		String nameTeamB = getNameTeam(partsTeamB);
		String scoreTeamB = getScoreTeam(partsTeamB);
		this.setTeamBName(nameTeamB);
		this.setTeamBScore(scoreTeamB);

	}

	private String getNameTeam(String[] partsTeam) {
		Pattern pattern = Pattern.compile("\\d+");

		return Stream.of(partsTeam)
				.filter(part -> !pattern.matcher(part).find())
				.collect(Collectors.joining(" "));
	}

	private String getScoreTeam(String[] partsTeam) {
		Pattern pattern = Pattern.compile("\\d+");

		List<String> scores = Stream.of(partsTeam)
				.filter(part -> pattern.matcher(part).find())
				.collect(Collectors.toList());
		return scores.get(0);
	}

	private String generateCurrentPeriodAndEliminateFromInput(String input) {
		String inputWithoutPeriod = "";
		String[] parts = input.split(" ");
		String currentPeriod = Stream.of(parts).filter(p -> p.contains("rd"))
				.findFirst().get();
		this.setCurrentPeriod(currentPeriod + " Quarter");
		inputWithoutPeriod = input.replaceAll(currentPeriod, "");
		inputWithoutPeriod = inputWithoutPeriod.replaceAll("Quarter", "");
		return inputWithoutPeriod;
	}
}
