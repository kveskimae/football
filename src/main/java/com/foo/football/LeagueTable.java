package com.foo.football;

import java.util.*;

import static java.util.Objects.isNull;

public class LeagueTable {

	private List<LeagueTableEntry> entries;

	public LeagueTable(final List<Match> matches) {
		this.entries = buildEntriesTable(matches);
	}

	private List<LeagueTableEntry> buildEntriesTable(List<Match> matches) {
		Map<String, LeagueTableEntry> team2TableEntry = new HashMap<>();

		for (Match match : matches) {
			LeagueTableEntry homeEntry = findOrCreateEntry(team2TableEntry, match.getHomeTeam​());

			addMatchToEntry(match, homeEntry, true);

			LeagueTableEntry awayEntry = findOrCreateEntry(team2TableEntry, match.getAwayTeam​());

			addMatchToEntry(match, awayEntry, false);
		}

		TreeSet<LeagueTableEntry> entries = new TreeSet<>();

		entries.addAll(team2TableEntry.values());

		return Collections.unmodifiableList(new ArrayList<>(entries.descendingSet()));
	}

	static void addMatchToEntry(Match match, LeagueTableEntry entry, boolean home) {
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

	static LeagueTableEntry findOrCreateEntry(Map<String, LeagueTableEntry> team2TableEntry, String teamName) {
		LeagueTableEntry entry = team2TableEntry.get(teamName);

		if (isNull(entry)) {
			entry = new LeagueTableEntry(teamName);
			team2TableEntry.put(teamName, entry);
		}

		return entry;
	}

	public List<LeagueTableEntry> getTableEntries() {
		return entries;
	}

}
