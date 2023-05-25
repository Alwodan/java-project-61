package hexlet.code.games;

import java.util.Random;

public class Even {
    public static final String MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static String currentQuestion;
    public static String generateQuestion() {
        Random random = new Random();
        currentQuestion = String.valueOf(random.nextInt(1000));
        return currentQuestion;
    }

    public static String generateAnswer() {
        if (Integer.parseInt(currentQuestion) % 2 == 0) {
            return "yes";
        } else {
            return "no";
        }
    }
}
