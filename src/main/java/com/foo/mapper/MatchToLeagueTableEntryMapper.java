package com.foo.mapper;

import com.foo.football.LeagueTableEntry;
import com.foo.match.Match;

import java.util.*;

import static com.foo.mapper.MatchAdder.addMatchToEntry;
import static java.util.Objects.isNull;

public class MatchToLeagueTableEntryMapper {

	private Map<String, LeagueTableEntry> team2Entry = new HashMap<>();

	public static Collection<LeagueTableEntry> map(List<Match> matches) {
		MatchToLeagueTableEntryMapper mapper = new MatchToLeagueTableEntryMapper();

		mapper.addMatches(matches);

		return mapper.team2Entry.values();
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
		LeagueTableEntry entry = team2Entry.get(teamName);

		if (isNull(entry)) {
			entry = new LeagueTableEntry(teamName);

			team2Entry.put(teamName, entry);
		}

		return entry;
	}

}
