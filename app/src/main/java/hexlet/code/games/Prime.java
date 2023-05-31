package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Prime {
    private static final int MAX_NUMBER = 100;
    public static final String MESSAGE = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static String generateQuestion() {
        Random random = new Random();
        return String.valueOf(random.nextInt(MAX_NUMBER));
    }

    public static void startGame() {
        Cli.greeting();
        System.out.println(MESSAGE);
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            String currentQuestion = generateQuestion();
            if (!Engine.handleRound(currentQuestion, generateAnswer(currentQuestion))) {
                return;
            }
        }
        Engine.sayGoodbye();
    }

    public static String generateAnswer(String question) {
        return isPrime(Integer.parseInt(question)) ? "yes" : "no";
    }

    private static boolean isPrime(int number) {
        //0 is non-prime
        if (number == 0) {
            return true;
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
