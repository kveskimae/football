package com.foo;

import com.foo.football.LeagueTable;
import com.foo.match.Match;
import com.foo.util.FixtureDownloadReader;

import java.util.List;

public class App {

	public static final String FILE_NAME = "epl-2018-GMTStandardTime.csv";

	public static void main(String[] args) {
		List<Match> matches = FixtureDownloadReader.readMatches(FILE_NAME);

		LeagueTable table = new LeagueTable(matches);

		table.print();
	}

}
