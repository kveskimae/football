package com.foo.util;

import com.foo.App;
import com.foo.match.Match;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.tuple.Pair;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.foo.util.HomeAndAwayScoreParser.parseHomeAndAwayScore;

public class FixtureDownloadReader {

	public static List<Match> readMatches(String fileName) {
		try {
			URL resource = FixtureDownloadReader.class.getClass().getResource(String.format("/%s", fileName));

			Validate.notNull(resource);

			Reader in  = new FileReader(resource.getFile());

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

}
