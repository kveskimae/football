package com.foo.football.util;

import com.foo.football.Match;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class MatchesReaderTests {

	@Test
	public void testParseHomeAndAwayScore() {
		Optional<Pair<Integer, Integer>> homeAndAwayScore = MatchesReader.parseHomeAndAwayScore("2 - 1");
		assertTrue(homeAndAwayScore.isPresent());
		assertEquals(2, homeAndAwayScore.get().getLeft().intValue());
		assertEquals(1, homeAndAwayScore.get().getRight().intValue());
	}

	@Test
	public void testParseHomeAndAwayScoreWithEmpty() {
		Optional<Pair<Integer, Integer>> homeAndAwayScore = MatchesReader.parseHomeAndAwayScore("");
		assertFalse(homeAndAwayScore.isPresent());
	}

	@Test
	public void testReadIn() {
		List<Match> matches = MatchesReader.readIn();

		List<Match> liverpoolMatches = matches
				.stream()
				.filter(
						match -> (
								match.getHomeTeam​().equals("Liverpool")
										|| match.getAwayTeam​().equals("Liverpool")
								)
				).collect(Collectors.toList());

		assertEquals(26, liverpoolMatches.size());
	}

}
