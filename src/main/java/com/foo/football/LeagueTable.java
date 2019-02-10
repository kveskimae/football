package com.foo.football;

import com.foo.mapper.MatchToLeagueTableEntryMapper;
import com.foo.match.Match;

import java.util.*;

public class LeagueTable {

	private List<LeagueTableEntry> entries;

	public LeagueTable(final List<Match> matches) {
		Collection<LeagueTableEntry> entriesAsCollection = MatchToLeagueTableEntryMapper.map(matches);

		TreeSet<LeagueTableEntry> sortedEntries = new TreeSet<>(entriesAsCollection);

		NavigableSet<LeagueTableEntry> reverseSortedEntries = sortedEntries.descendingSet();

		List<LeagueTableEntry> reverseSortedEntriesAsList = new ArrayList<>(reverseSortedEntries);

		this.entries = Collections.unmodifiableList(reverseSortedEntriesAsList);
	}

	public List<LeagueTableEntry> getTableEntries() {
		return entries;
	}

	public void print() {
		System.out.println("           Club : Pts   W   D   L   GD");
		System.out.println("           ---- : ---   -   -   -   --");
		for (LeagueTableEntry entry : getTableEntries()) {
			System.out.println(
					String.format(
							"%15s : %3d %3d %3d %3d %4d",
							entry.getTeamName​(),
							entry.getPoints(),
							entry.getWon(),
							entry.getDrawn(),
							entry.getLost(),
							entry.getGoalDifference()
					)
			);
		}
	}

}
