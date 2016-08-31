package entities;

public abstract  class Entity {
	private String teamAName;
	private String teamAScore;
	private String teamBName;
	private String teamBScore;
	
	
	public String getTeamAName() {
		return teamAName;
	}


	public void setTeamAName(String teamAName) {
		this.teamAName = teamAName;
	}


	public String getTeamAScore() {
		return teamAScore;
	}


	public void setTeamAScore(String teamAScore) {
		this.teamAScore = teamAScore;
	}


	public String getTeamBName() {
		return teamBName;
	}


	public void setTeamBName(String teamBName) {
		this.teamBName = teamBName;
	}


	public String getTeamBScore() {
		return teamBScore;
	}


	public void setTeamBScore(String teamBScore) {
		this.teamBScore = teamBScore;
	}


	public  abstract void generate(String input);
}
