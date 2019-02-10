package com.foo.football.util;

import com.foo.football.Match;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MatchesReader {

	public static List<Match> readIn() {
		try {
			Reader in  = new FileReader("src/test/resources/epl-2018-GMTStandardTime.csv");

			Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
			List<Match> matches = new ArrayList<>();
			for (CSVRecord record : records) {
				String homeTeam​ = record.get("Home Team");
				String awayTeam​ = record.get("Away Team");
				String result = record.get("Result");
				Optional<Pair<Integer, Integer>> maybeHomeAndAwayScore = parseHomeAndAwayScore(result);
				if (maybeHomeAndAwayScore.isPresent()) {
					Pair<Integer, Integer> homeAndAwayScore = maybeHomeAndAwayScore.get();
					int homeScore​ = homeAndAwayScore.getLeft();
					int awayScore​ = homeAndAwayScore.getRight();

					Match match = new Match(homeTeam​, awayTeam​, homeScore​, awayScore​);
					matches.add(match);
				}
			}

			return matches;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

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
