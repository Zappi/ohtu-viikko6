package statistics.matcher;


import java.util.ArrayList;

public class QueryBuilder {

    private ArrayList<Matcher> matchers;
    private boolean isOr = false;

    public QueryBuilder() {
        this.matchers= new ArrayList<>();

    }

    public QueryBuilder hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder oneOf(Matcher... matcher) {
        isOr = true;
        for (Matcher newMatcher: matcher) {
            matchers.add(newMatcher);
        }
        return this;
    }

    public Matcher build() {

        Matcher[] matcher = new Matcher[matchers.size()];

        int i = 0;
        for (Matcher newMatcher : matchers) {
            matcher[i] = newMatcher;
            i++;
        }
        this.matchers = new ArrayList<>();
        if(this.isOr) {
            return new Or(matcher);
        } else {
            return new And(matcher);
        }

    }
}
