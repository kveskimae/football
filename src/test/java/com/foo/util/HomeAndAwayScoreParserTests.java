package com.foo.util;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class HomeAndAwayScoreParserTests {

	@Test
	public void testParseHomeAndAwayScore() {
		Optional<Pair<Integer, Integer>> homeAndAwayScore = HomeAndAwayScoreParser.parseHomeAndAwayScore("2 - 1");
		assertTrue(homeAndAwayScore.isPresent());
		assertEquals(2, homeAndAwayScore.get().getLeft().intValue());
		assertEquals(1, homeAndAwayScore.get().getRight().intValue());
	}

	@Test
	public void testParseHomeAndAwayScoreWithEmpty() {
		Optional<Pair<Integer, Integer>> homeAndAwayScore = HomeAndAwayScoreParser.parseHomeAndAwayScore("");
		assertFalse(homeAndAwayScore.isPresent());
	}

}
