import java.io.Serializable;


public class Team implements Serializable {
	private int rank;
	private int rating;
	private int winrate;
	private int currentStreak;
	private String teamName;
	private String country;
	private String matchesPlayed;
	private String lastMatch;

	public Team(int rank, int rating, int winrate, int currentStreak,
			String teamName, String country, String matchesPlayed,
			String lastMatch) {
		super();
		this.rank = rank;
		this.rating = rating;
		this.winrate = winrate;
		this.currentStreak = currentStreak;
		this.teamName = teamName;
		this.country = country;
		this.matchesPlayed = matchesPlayed;
		this.lastMatch = lastMatch;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getWinrate() {
		return winrate;
	}

	public void setWinrate(int winrate) {
		this.winrate = winrate;
	}

	public int getCurrentStreak() {
		return currentStreak;
	}

	public void setCurrentStreak(int currentStreak) {
		this.currentStreak = currentStreak;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMatchesPlayed() {
		return matchesPlayed;
	}

	public void setMatchesPlayed(String matchesPlayed) {
		this.matchesPlayed = matchesPlayed;
	}

	public String getLastMatch() {
		return lastMatch;
	}

	public void setLastMatch(String lastMatch) {
		this.lastMatch = lastMatch;
	}

}
