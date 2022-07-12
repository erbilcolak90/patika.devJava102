import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FixtureGenerator {

    public List<List<Match>> getFixture(List<String> teams) {

        int teamCount = teams.size();

        if (teamCount % 2 != 0) {
            teamCount++;
        }

        //randomize to all teams
        Collections.shuffle(teams);

        int allRounds = teamCount - 1;
        int matchesPerRound = teamCount / 2;
        List<List<Match>> rounds = new LinkedList<>();
        for (int round = 0; round < allRounds; round++)
        {

            List<Match> matches = new LinkedList<>();

            for (int match = 0; match < matchesPerRound; match++)
            {
                int home = (round + match) % (teamCount - 1);
                int away = (teamCount - 1 - match + round) % (teamCount - 1);
                // shifting all teams while stay last team
                if (match == 0) {
                    away = teamCount - 1;
                }
                matches.add(new Match(teams.get(home), teams.get(away)));
            }
            rounds.add(matches);
        }


        // Half of the season
        List<List<Match>> secondHalfFixture = new LinkedList<>();
        for (List<Match> round : rounds) {
            List<Match> reverseRound = new LinkedList<>();
            for (Match match : round) {
                reverseRound.add(new Match(match.getAwayTeam(), match.getHomeTeam()));
            }
            secondHalfFixture.add(reverseRound);
        }
        rounds.addAll(secondHalfFixture);
        return rounds;
    }

    public void print(List<List<Match>> all) {
        int count = 1;
        for (List<Match> round : all) {
            System.out.println("***---" + count + ". Round ---***");
            count++;
            for (Match match : round) {
                System.out.println(match.getHomeTeam() + "-" + match.getAwayTeam());
            }

        }
    }
}
