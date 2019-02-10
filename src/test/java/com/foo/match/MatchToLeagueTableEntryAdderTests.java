package com.foo.match;

import com.foo.football.LeagueTableEntry;
import org.junit.jupiter.api.Test;

import static com.foo.match.MatchToLeagueTableEntryAdder.addMatchToEntry;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MatchToLeagueTableEntryAdderTests {

	@Test
	public void testAddMatchToEntryHome() {
		Match match = new Match("Team1", "Team2", 6, 2);
		LeagueTableEntry entry = new LeagueTableEntry("Team1");
		addMatchToEntry(match, entry, true);
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
		addMatchToEntry(match, entry, false);
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
		addMatchToEntry(match, entry, false);
		assertEquals("Team2", entry.getTeamName​());
		assertEquals(0, entry.getWon());
		assertEquals(1, entry.getDrawn());
		assertEquals(0, entry.getLost());
		assertEquals(1, entry.getPoints());
		assertEquals(0, entry.getGoalDifference());
	}

}
