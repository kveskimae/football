package com.foo.match;

import com.foo.football.LeagueTableEntry;

public class MatchToLeagueTableEntryAdder {

	public static void addMatchToEntry(Match match, LeagueTableEntry entry, boolean home) {
		entry.setDrawn(entry.getDrawn() + (match.isDraw() ? 1 : 0));
		entry.setWon(
				entry.getWon()
						+ (!match.isDraw() && home == match.isHomeWin() ? 1 : 0)
		);
		entry.setLost(
				entry.getLost()
						+ (!match.isDraw() && home ^ match.isHomeWin() ? 1 : 0)
		);
		entry.setGoalsFor(
				entry.getGoalsFor()
						+ (home ? match.getHomeScore​() : match.getAwayScore​())
		);
		entry.setGoalsAgainst(
				entry.getGoalsAgainst()
						+ (home ? match.getAwayScore​() : match.getHomeScore​())
		);
	}

}
