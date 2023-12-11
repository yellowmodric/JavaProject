package movingball;

public class RankingEntry {
    private String username;
    private long time;

    public RankingEntry(String username, long time) {
        this.username = username;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public long getTime() {
        return time;
    }
}