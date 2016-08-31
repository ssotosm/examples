package entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tennis extends Entity {
	
	private String teamAGames;
	private String teamBGames;
	private boolean teamBServing;
	private ScoreBoard scoreBoard;

	public Tennis() {
		 scoreBoard= new ScoreBoard();
		 scoreBoard.getElements().put("title", "sets");
	}


	public String getTeamAGames() {
		return teamAGames;
	}

	public void setTeamAGames(String teamAGames) {
		this.teamAGames = teamAGames;
	}

	public String getTeamBGames() {
		return teamBGames;
	}

	public void setTeamBGames(String teamBGames) {
		this.teamBGames = teamBGames;
	}

	public boolean isTeamBServing() {
		return teamBServing;
	}

	public void setTeamBServing(boolean teamBServing) {
		this.teamBServing = teamBServing;
	}

	public ScoreBoard getScoreBoard() {
		return scoreBoard;
	}

	public void setScoreBoard(ScoreBoard scoreBoard) {
		this.scoreBoard = scoreBoard;
	}

	@Override
	public void generate(String input) {
		String[] teams = input.split("-");
		List<String> resultTeams = new ArrayList<>();
		Stream.of(teams).forEach(team -> resultTeams.add(team));

		generateTeamA(teams);

		generateTeamB(teams);

	}

	private void generateTeamA(String[] teams) {

		String teamA = teams[0];
		String[] partsTeamA = teamA.split(" ");

		String nameTeamA = getNameTeam(partsTeamA);

		boolean teamAScoreAdv = nameTeamA.contains("Adv");
		nameTeamA = teamAScoreAdv ? nameTeamA.replace("Adv", "") : nameTeamA;

		Map<String, String> scoresTeamA = getScoresTeam(partsTeamA,
				teamAScoreAdv,true);
		this.setTeamAName(nameTeamA);
		this.setTeamAGames(scoresTeamA.get("game"));
		this.setTeamAScore(scoresTeamA.get("score"));
		
		this.scoreBoard.getElements().put("teamAScore", scoresTeamA.get("scoreBoard"));
	}

	private void generateTeamB(String[] teams) {
		String teamB = teams[1];
		String[] partsTeamB = teamB.split(" ");

		String nameTeamB = getNameTeam(partsTeamB);

		boolean teamBScoreAdv = nameTeamB.contains("Adv");
		nameTeamB = teamBScoreAdv ? nameTeamB.replace("Adv", "") : nameTeamB;

		boolean teamBServing = nameTeamB.contains("*");
		nameTeamB = teamBServing ? nameTeamB.replace("*", "") : nameTeamB;

		Map<String, String> scoresTeamB = getScoresTeam(partsTeamB,
				teamBScoreAdv,false);
		
		this.setTeamBName(nameTeamB);
		this.setTeamBGames(scoresTeamB.get("game"));
		this.setTeamBScore(scoresTeamB.get("score"));
		this.setTeamBServing(teamBServing);
		
		this.scoreBoard.getElements().put("teamBScore", scoresTeamB.get("scoreBoard"));
	}

	private Map<String, String> getScoresTeam(String[] partsTeam, boolean isAdv, boolean firstTeam) {
		Pattern pattern = Pattern.compile("\\d+");

		List<String> scores = Stream.of(partsTeam)
				.filter(part -> pattern.matcher(part).find())
				.collect(Collectors.toList());

		String scoreboardTeamScore = scores.stream()
				.filter(s -> s.contains("(")).findAny().get()
				.replaceAll("[()]", "");

		List<String> scoreAndGame = new LinkedList<String>();
		scoreAndGame = scores.stream().filter(s -> !s.contains("("))
				.collect(Collectors.toList());
		String score = "";
		String games = "";
		if (!isAdv) {
			games = firstTeam ?scoreAndGame.get(0):scoreAndGame.get(1);
			score = firstTeam ?scoreAndGame.get(1):scoreAndGame.get(0);
		} else {
			score = "Adv";
			games = scoreAndGame.get(0);
		}
		Map<String, String> scoresTeam = new HashMap<>();
		scoresTeam.put("score", score);
		scoresTeam.put("game", games);
		scoresTeam.put("scoreBoard", scoreboardTeamScore);
		return scoresTeam;
	}

	private String getNameTeam(String[] partsTeam) {
		Pattern pattern = Pattern.compile("\\d+");

		return Stream.of(partsTeam)
				.filter(part -> !pattern.matcher(part).find())
				.collect(Collectors.joining(" "));
	}

}
