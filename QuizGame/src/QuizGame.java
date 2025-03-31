import java.util.*;

public class QuizGame {
    private List<Question> questions;
    private int score;
    private int skipped;
    private Scanner scanner;
    private Leaderboard leaderboard;
    private HintSystem hintSystem;

    public QuizGame() {
        this.questions = loadQuestions();
        this.score = 0;
        this.skipped = 0;
        this.scanner = new Scanner(System.in);
        this.leaderboard = new Leaderboard();
        this.hintSystem = new HintSystem();
    }

    private List<Question> loadQuestions() {
        return Arrays.asList(
                new Question("What is the capital of France?", "Paris", "It's also called the City of Lights."),
                new Question("What is 5 + 7?", "12", "Think basic addition."),
                new Question("Which planet is known as the Red Planet?", "Mars", "It's named after the Roman god of war."),
                new Question("How many bones are in the human body?", "206", "It's above 50."),
                new Question("What is the tallest mountain in the world?", "Mount Everest", "It's in the Himalayas."),
                new Question("What is the fastest land animal?", "Cheetah", "It can run up to 75 mph."),
                new Question("What is the main ingredient in guacamole?", "Avocado", "It's a green fruit."),
                new Question("Which ocean is the largest?", "Pacific", "It covers more area than all land combined."),
                new Question("Who painted the Mona Lisa?", "Leonardo da Vinci", "He was also an inventor."),
                new Question("What is the smallest planet in our solar system?", "Mercury", "It's the closest to the Sun.")
        );
    }

    public void startGame() {
        System.out.println("Welcome to the Quiz Game! Answer the questions or type 'skip' to move to the next.");
        for (Question question : questions) {
            System.out.println("Question: " + question.getQuestionText());
            System.out.println("Need a hint? Type 'hint'.");

            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("skip")) {
                skipped++;
                continue;
            }
            if (answer.equalsIgnoreCase("hint")) {
                System.out.println("Hint: " + question.getHint());
                answer = scanner.nextLine();
            }
            if (answer.equalsIgnoreCase(question.getAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong answer. The correct answer was: " + question.getAnswer());
            }
        }
        endGame();
    }

    private void endGame() {
        System.out.println("Game Over! Your score: " + score);
        System.out.println("Questions skipped: " + skipped);
        leaderboard.addScore(new User("Player", score));
        leaderboard.displayLeaderboard();
        SummaryEmail.sendSummary("player@example.com", score, skipped);
    }

    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.startGame();
    }
}
