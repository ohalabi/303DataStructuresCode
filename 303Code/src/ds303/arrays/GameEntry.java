package ds303.arrays;

public class GameEntry {
    private String name;        // name of the person earning this score
    private int score;          // the score value
    /** Constructs a game entry with given parameters.. */
    public GameEntry(String n, int s) {
        name = n;
        score = s;
    }
    /** Returns the name field. */
    public String getName() { return name; }
    /** Returns the score field. */
    public int getScore() { return score; }
    /** Returns a string representation of this entry. */
    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}
