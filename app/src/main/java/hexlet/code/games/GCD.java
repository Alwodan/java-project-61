package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class GCD {
    public static final String MESSAGE = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_MAX = 100;

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

    public static String generateQuestion() {
        Random random = new Random();
        int firstNumber = random.nextInt(NUMBER_MAX) + 1;
        int secondNumber = random.nextInt(NUMBER_MAX) + 1;
        return firstNumber + " " + secondNumber;
    }

    public static String generateAnswer(String question) {
        String[] elements = question.split(" ");
        return String.valueOf(getResult(Integer.parseInt(elements[0]), Integer.parseInt(elements[1])));
    }

    private static int getResult(int firstNumber, int secondNumber) {
        if (firstNumber > secondNumber) {
            return findGCD(firstNumber, secondNumber);
        } else if (firstNumber < secondNumber) {
            return findGCD(secondNumber, firstNumber);
        } else {
            return firstNumber;
        }
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }
}
