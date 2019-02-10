package com.foo.util;

import com.foo.match.Match;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.foo.App.FILE_NAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FixtureDownloadReaderTests {

	@Test
	public void testReadIn() {
		List<Match> matches = FixtureDownloadReader.readMatches(FILE_NAME);

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
