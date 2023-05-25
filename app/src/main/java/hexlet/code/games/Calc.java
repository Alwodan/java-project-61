package hexlet.code.games;

import java.util.Random;

public class Calc {
    public static final String MESSAGE = "What is the result of the expression?";
    private static final int NUMBER_MAX = 100;
    private static String currentQuestion;
    public static String generateQuestion() {
        Random random = new Random();
        String operand;
        int firstNumber = random.nextInt(NUMBER_MAX);
        int secondNumber = random.nextInt(NUMBER_MAX);
        int operation = random.nextInt(3);
        operand = switch (operation) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
        currentQuestion = firstNumber + " " + operand + " " + secondNumber;
        return currentQuestion;
    }

    public static String generateAnswer() {
        String[] elements = currentQuestion.split(" ");
        int firstNumber = Integer.parseInt(elements[0]);
        int secondNumber = Integer.parseInt(elements[2]);
        if (elements[1].equals("+")) {
            return String.valueOf(firstNumber + secondNumber);
        } else if (elements[1].equals("-")) {
            return String.valueOf(firstNumber - secondNumber);
        } else {
            return String.valueOf(firstNumber * secondNumber);
        }
    }
}
