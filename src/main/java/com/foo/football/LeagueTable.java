package com.foo.football;

import com.foo.match.Match;

import java.util.*;

public class LeagueTable {

	private List<LeagueTableEntry> entries;

	public LeagueTable(final List<Match> matches) {
		this.entries = LeagueTableEntryListBuilder.of(matches);
	}

	public List<LeagueTableEntry> getTableEntries() {
		return entries;
	}

	public void print() {
		System.out.println("           Club : Pts   W   D   L   GD");
		System.out.println("           ---- : ---   -   -   -   --");
		for (LeagueTableEntry entry : entries) {
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
