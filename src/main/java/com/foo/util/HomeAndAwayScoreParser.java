package com.foo.util;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Optional;

public class HomeAndAwayScoreParser {

	static Optional<Pair<Integer, Integer>> parseHomeAndAwayScore(String result) {
		String[] bits = result.split("-");
		if (bits.length == 2) {
			String homeScoreAsString = bits[0].trim();
			String awayScoreAsString = bits[1].trim();

			Integer homeScore = Integer.valueOf(homeScoreAsString);
			Integer awayScore = Integer.valueOf(awayScoreAsString);

			return Optional.of(Pair.of(homeScore, awayScore));
		}
		return Optional.empty();
	}

}
