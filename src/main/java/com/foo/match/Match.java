package com.foo.match;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Match {

	private String homeTeam​;
	private String awayTeam​;
	private int homeScore​;
	private int awayScore​;

	public Match(String homeTeam​, String awayTeam​, int homeScore​, int awayScore​) {
		this.homeTeam​ = homeTeam​;
		this.awayTeam​ = awayTeam​;
		this.homeScore​ = homeScore​;
		this.awayScore​ = awayScore​;
	}

	public String getHomeTeam​() {
		return homeTeam​;
	}

	public String getAwayTeam​() {
		return awayTeam​;
	}

	public int getHomeScore​() {
		return homeScore​;
	}

	public int getAwayScore​() {
		return awayScore​;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public boolean isDraw() {
		return Integer.compare(homeScore​, awayScore​) == 0;
	}

	public boolean isHomeWin() {
		return Integer.compare(homeScore​, awayScore​) > 0;
	}

}