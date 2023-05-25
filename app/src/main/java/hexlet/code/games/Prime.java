package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static int currentQuestion;
    public static final String MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String generateQuestion() {
        Random random = new Random();
        currentQuestion = random.nextInt(100);
        return String.valueOf(currentQuestion);
    }

    public static String generateAnswer() {
        for (int i = 2; i < currentQuestion / 2; i++) {
            if (currentQuestion % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
