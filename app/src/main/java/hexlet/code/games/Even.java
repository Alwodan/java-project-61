package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Even {
    public static final String MESSAGE = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int MAX_NUMBER = 1000;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            String question = String.valueOf(Utils.getRandomInt(0, MAX_NUMBER));
            String answer = isEven(Integer.parseInt(question)) ? "yes" : "no";

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    private static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
