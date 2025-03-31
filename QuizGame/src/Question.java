public class Question {
    private String questionText;
    private String answer;
    private String hint;

    public Question(String questionText, String answer, String hint) {
        this.questionText = questionText;
        this.answer = answer;
        this.hint = hint;
    }

    public String getQuestionText() { return questionText; }
    public String getAnswer() { return answer; }
    public String getHint() { return hint; }
}

