package com.foo.football;

import java.util.Objects;

public class LeagueTableEntry implements Comparable<LeagueTableEntry> {

	private String teamName​;
	private int won​;
	private int drawn​;
	private int lost​;
	private int goalsFor​;
	private int goalsAgainst​;

	public LeagueTableEntry(String teamName​) {
		this(teamName​, 0, 0, 0, 0, 0);
	}

	public LeagueTableEntry(String teamName​, int won​, int drawn​, int lost​, int goalsFor​, int goalsAgainst​​) {
		this.teamName​ = teamName​;
		this.won​ = won​;
		this.drawn​ = drawn​;
		this.lost​ = lost​;
		this.goalsFor​ = goalsFor​;
		this.goalsAgainst​ = goalsAgainst​;
	}

	public String getTeamName​() {
		return teamName​;
	}

	public int getPlayed() {
		return getWon() + getDrawn() + getLost();
	}

	public int getWon() {
		return won​;
	}

	public void setWon(int won​) {
		this.won​ = won​;
	}

	public int getDrawn() {
		return drawn​;
	}

	public void setDrawn(int drawn​) {
		this.drawn​ = drawn​;
	}

	public int getLost() {
		return lost​;
	}

	public void setLost(int lost​) {
		this.lost​ = lost​;
	}

	public int getGoalsFor() {
		return goalsFor​;
	}

	public void setGoalsFor(int goalsFor​) {
		this.goalsFor​ = goalsFor​;
	}

	public int getGoalsAgainst() {
		return goalsAgainst​;
	}

	public void setGoalsAgainst(int goalsAgainst​) {
		this.goalsAgainst​ = goalsAgainst​;
	}

	public int getGoalDifference() {
		return getGoalsFor() - getGoalsAgainst();
	}

	public int getPoints() {
		return 3 * getWon() + 1 * getDrawn() + 0 * getLost();
	}

	@Override
	public int compareTo(LeagueTableEntry o) {
		if (Integer.compare(this.getPoints(), o.getPoints()) != 0) {
			return Integer.compare(this.getPoints(), o.getPoints());
		} else if (Integer.compare(this.getGoalDifference(), o.getGoalDifference()) != 0) {
			return Integer.compare(this.getGoalDifference(), o.getGoalDifference());
		} else if (Integer.compare(this.getGoalsFor(), o.getGoalsFor()) != 0) {
			return Integer.compare(this.getGoalsFor(), o.getGoalsFor());
		} else {
			return this.getTeamName​().compareTo(o.getTeamName​());
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		LeagueTableEntry that = (LeagueTableEntry) o;
		return teamName​.equals(that.teamName​);
	}

	@Override
	public int hashCode() {
		return Objects.hash(teamName​);
	}
}
