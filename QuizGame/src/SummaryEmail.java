public class SummaryEmail {
    public static void sendSummary(String email, int score, int skipped) {
        System.out.println("Summary sent to " + email + " with score " + score + " and " + skipped + " skipped questions.");
    }
}
