package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Even {
    public static final String MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 1000;

    public static void startGame() {
        Cli.greeting();
        System.out.println(MESSAGE);
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer(questionsAndAnswers[i][0]);
        }
        if (Engine.handleGame(questionsAndAnswers)) {
            Engine.sayGoodbye();
        }
    }
    private static String generateQuestion() {
        Random random = new Random();
        return String.valueOf(random.nextInt(MAX_NUMBER));
    }

    private static String generateAnswer(String question) {
        return isEven(Integer.parseInt(question)) ? "yes" : "no";
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
