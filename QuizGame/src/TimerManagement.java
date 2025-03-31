import java.util.concurrent.TimeUnit;

public class TimerManagement {
    private long startTime;

    public void startTimer() { startTime = System.currentTimeMillis(); }

    public void stopTimer() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("Time taken: " + TimeUnit.MILLISECONDS.toSeconds(elapsedTime) + " seconds");
    }
}
