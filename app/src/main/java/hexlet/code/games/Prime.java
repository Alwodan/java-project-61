package hexlet.code.games;

import java.util.Random;

public class Prime {
    private static int currentQuestion;
    private static final int MAX_NUMBER = 100;
    public static final String MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String generateQuestion() {
        Random random = new Random();
        currentQuestion = random.nextInt(MAX_NUMBER);
        return String.valueOf(currentQuestion);
    }

    public static String generateAnswer() {
        // +1 so number 4 can pass
        for (int i = 2; i < (currentQuestion / 2) + 1; i++) {
            if (currentQuestion % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
