import java.util.*;

public class Leaderboard {
    private List<User> scores = new ArrayList<>();

    public void addScore(User user) { scores.add(user); }

    public void displayLeaderboard() {
        scores.sort(Comparator.comparingInt(User::getScore).reversed());
        System.out.println("Leaderboard:");
        scores.forEach(user -> System.out.println(user.getName() + " - " + user.getScore()));
    }
}
