package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final int MAX_NUMBER = 100;
    public static final String MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            String question = String.valueOf(Utils.getRandomInt(0, MAX_NUMBER));
            String answer = isPrime(Integer.parseInt(question)) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        // +1 so number 4 can pass
        for (int i = 2; i < (number / 2) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
