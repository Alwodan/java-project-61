package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String MESSAGE = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_MAX = 100;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            int firstNumber = Utils.getRandomInt(0, NUMBER_MAX) + 1;
            int secondNumber = Utils.getRandomInt(0, NUMBER_MAX) + 1;

            String question = firstNumber + " " + secondNumber;
            String answer = String.valueOf(findGCD(firstNumber, secondNumber));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    private static int findGCD(int number1, int number2) {
        while (number1 != 0 && number2 != 0) {
            if (number1 > number2) {
                number1 = number1 % number2;
            } else {
                number2 = number2 % number1;
            }
        }
        return number1 + number2;
    }
}
