package com.foo.football;

import com.foo.football.util.MatchesReader;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LeagueTableTests {

	@Test
	public void testNoMatchesPlayed() {
		LeagueTable table = new LeagueTable(Collections.EMPTY_LIST);
		assertNotNull(table.getTableEntries());
		assertEquals(0, table.getTableEntries().size());
	}

	@Test
	public void testFebruary10MorningStandings() {
		List<Match> matches = MatchesReader.readIn();

		LeagueTable table = new LeagueTable(matches);

		assertNotNull(table.getTableEntries());
		assertEquals(20, table.getTableEntries().size());

		LeagueTableEntry first = table.getTableEntries().get(0);

		assertEquals("Liverpool", first.getTeamName​());
		assertEquals(26, first.getPlayed());
		assertEquals(20, first.getWon());
		assertEquals(5, first.getDrawn());
		assertEquals(1, first.getLost());
		assertEquals(59, first.getGoalsFor());
		assertEquals(15, first.getGoalsAgainst());
		assertEquals(44, first.getGoalDifference());
		assertEquals(65, first.getPoints());

		LeagueTableEntry second = table.getTableEntries().get(1);

		assertEquals("Man City", second.getTeamName​());
		assertEquals(62, second.getPoints());

		LeagueTableEntry place13 = table.getTableEntries().get(12);
		LeagueTableEntry place14 = table.getTableEntries().get(13);
		LeagueTableEntry place15 = table.getTableEntries().get(14);

		assertEquals("Crystal Palace", place13.getTeamName​());
		assertEquals(27, place13.getPoints());
		assertEquals("Brighton", place14.getTeamName​());
		assertEquals(27, place14.getPoints());
		assertEquals("Burnley", place15.getTeamName​());
		assertEquals(27, place15.getPoints());

		LeagueTableEntry last = table.getTableEntries().get(19);

		assertEquals("Huddersfield", last.getTeamName​());
		assertEquals(11, last.getPoints());
	}

	@Test
	public void testAddMatchToEntryHome() {
		Match match = new Match("Team1", "Team2", 6, 2);
		LeagueTableEntry entry = new LeagueTableEntry("Team1");
		LeagueTable.addMatchToEntry(match, entry, true);
		assertEquals("Team1", entry.getTeamName​());
		assertEquals(1, entry.getWon());
		assertEquals(0, entry.getDrawn());
		assertEquals(0, entry.getLost());
		assertEquals(3, entry.getPoints());
		assertEquals(4, entry.getGoalDifference());
	}

	@Test
	public void testAddMatchToEntryAway() {
		Match match = new Match("Team1", "Team2", 6, 2);
		LeagueTableEntry entry = new LeagueTableEntry("Team2");
		LeagueTable.addMatchToEntry(match, entry, false);
		assertEquals("Team2", entry.getTeamName​());
		assertEquals(0, entry.getWon());
		assertEquals(0, entry.getDrawn());
		assertEquals(1, entry.getLost());
		assertEquals(0, entry.getPoints());
		assertEquals(-4, entry.getGoalDifference());
	}

	@Test
	public void testAddMatchToEntryDraw() {
		Match match = new Match("Team1", "Team2", 5, 5);
		LeagueTableEntry entry = new LeagueTableEntry("Team2");
		LeagueTable.addMatchToEntry(match, entry, false);
		assertEquals("Team2", entry.getTeamName​());
		assertEquals(0, entry.getWon());
		assertEquals(1, entry.getDrawn());
		assertEquals(0, entry.getLost());
		assertEquals(1, entry.getPoints());
		assertEquals(0, entry.getGoalDifference());
	}
	
}
