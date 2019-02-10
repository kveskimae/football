# Football

Builds a league table for a sports competition.

Match results for testing were Premier League games played by the morning of February 10, 2019 and downloaded from [Fixture Download](https://fixturedownload.com/results/epl-2018).

LeagueTableEntry was modified to better confirm to [DRY](https://en.wikipedia.org/wiki/Don%27t_repeat_yourself) by removing duplication of information that would need extra work for keeping in sync. 

The functions were not substantially abstracted yet, as per [Rule of three](https://en.wikipedia.org/wiki/Rule_of_three_(computer_programming%29) the design would benefit from additional samples.

## Trying out

Start from 
````    
com.foo.App
````

