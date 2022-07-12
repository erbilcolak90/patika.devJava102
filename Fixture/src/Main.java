import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("Arsenal");
        list.add("Chelsea");
        list.add("Manchester City");
        list.add("Manchester United");
        list.add("Everton");
        list.add("Liverpool");

        FixtureGenerator fixtureGenerate = new FixtureGenerator();

        List<List<Match>> allMatches = fixtureGenerate.getFixture(list);

        fixtureGenerate.print(allMatches);

    }
}
