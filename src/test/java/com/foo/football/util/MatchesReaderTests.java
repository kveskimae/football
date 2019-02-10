package com.foo.football.util;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Optional;

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

}
