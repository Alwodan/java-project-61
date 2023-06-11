package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Calc {
    public static final String MESSAGE = "What is the result of the expression?";
    private static final int NUMBER_MAX = 100;
    private static final int NUMBER_OF_OPERATIONS = 3;

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
        String operand;
        int firstNumber = random.nextInt(NUMBER_MAX);
        int secondNumber = random.nextInt(NUMBER_MAX);
        int operation = random.nextInt(NUMBER_OF_OPERATIONS);
        operand = switch (operation) {
            case 0 -> "+";
            case 1 -> "-";
            default -> "*";
        };
        return firstNumber + " " + operand + " " + secondNumber;
    }

    public static String generateAnswer(String currentQuestion) {
        String[] elements = currentQuestion.split(" ");
        String operand = elements[1];
        int firstNumber = Integer.parseInt(elements[0]);
        int secondNumber = Integer.parseInt(elements[2]);
        return String.valueOf(getResult(firstNumber, secondNumber, operand));
    }

    private static int getResult(int firstNumber, int secondNumber, String operand) {
        if (operand.equals("+")) {
            return firstNumber + secondNumber;
        } else if (operand.equals("-")) {
            return firstNumber - secondNumber;
        } else {
            return firstNumber * secondNumber;
        }
    }
}
