package movingball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserManage {
    private String username;
    private List<RankingEntry> ranking;
    private String txt;
    private long startTime, endTime;

    public UserManage() {
        username = null;
        startTime = 0;
        endTime = 0;
        ranking = new ArrayList<>();
    }

    public void setUser(String name, long time) {
        username = name;
        startTime = time;
    }

    public void addRankingEntry(long time) {
        endTime = time;
        ranking.add(new RankingEntry(username, endTime - startTime));
        Collections.sort(ranking, (e1, e2) -> Long.compare(e1.getTime(), e2.getTime()));
    }

    public String getTxt() {
        txt = username + "의 걸린 시간: " + (endTime - startTime) + " 초\n랭킹:\n";
        for (int i = 0; i < Math.min(ranking.size(), 3); i++) {
            RankingEntry entry = ranking.get(i);
            txt += ((i + 1) + ". " + entry.getUsername() + " - " + entry.getTime() + "초\n");
        }
        return txt;
    }

}
