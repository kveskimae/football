package com.foo.football;

import com.foo.match.Match;

import java.util.*;

import static com.foo.match.MatchToLeagueTableEntryAdder.addMatchToEntry;
import static java.util.Objects.isNull;

public class LeagueTableEntryListBuilder {

	private Map<String, LeagueTableEntry> team2TableEntry = new HashMap<>();

	public static List<LeagueTableEntry> of(List<Match> matches) {
		LeagueTableEntryListBuilder builder = new LeagueTableEntryListBuilder();

		builder.addMatches(matches);

		return builder.getSortedList();
	}

	public List<LeagueTableEntry> getSortedList() {
		TreeSet<LeagueTableEntry> entries = new TreeSet<>(team2TableEntry.values());

		return Collections.unmodifiableList(new ArrayList<>(entries.descendingSet()));
	}

	private void addMatches(List<Match> matches) {
		for (Match match : matches) {
			LeagueTableEntry homeEntry = findOrCreateEntry(match.getHomeTeam​());

			addMatchToEntry(match, homeEntry, true);

			LeagueTableEntry awayEntry = findOrCreateEntry(match.getAwayTeam​());

			addMatchToEntry(match, awayEntry, false);
		}
	}

	private LeagueTableEntry findOrCreateEntry(String teamName) {
		LeagueTableEntry entry = team2TableEntry.get(teamName);

		if (isNull(entry)) {
			entry = new LeagueTableEntry(teamName);

			team2TableEntry.put(teamName, entry);
		}

		return entry;
	}

}
