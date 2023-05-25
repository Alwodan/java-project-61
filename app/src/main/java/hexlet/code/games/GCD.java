package hexlet.code.games;

import java.util.Random;

public class GCD {
    private static String currentAnswer;
    public static String currentQuestion;
    public static final String MESSAGE = "Find the greatest common divisor of given numbers.";
    private static final int NUMBER_MAX = 100;

    public static String generateQuestion() {
        Random random = new Random();
        int firstNumber = random.nextInt(NUMBER_MAX) + 1;
        int secondNumber = random.nextInt(NUMBER_MAX) + 1;
        if (firstNumber > secondNumber) {
            currentAnswer = String.valueOf(findGCD(firstNumber, secondNumber));
        } else if (firstNumber < secondNumber) {
            currentAnswer = String.valueOf(findGCD(secondNumber, firstNumber));
        } else {
            currentAnswer = String.valueOf(firstNumber);
        }
        return firstNumber + " " + secondNumber;
    }

    public static String generateAnswer() {
        return currentAnswer;
    }

    private static int findGCD(int number1, int number2) {
        if (number2 == 0) {
            return number1;
        }
        return findGCD(number2, number1 % number2);
    }
}
