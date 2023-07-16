package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String MESSAGE = "What is the result of the expression?";
    private static final int NUMBER_MAX = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            questionsAndAnswers[i][0] = generateQuestion();
            questionsAndAnswers[i][1] = generateAnswer(questionsAndAnswers[i][0]);
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    public static String generateQuestion() {
        String operand = OPERATORS[Utils.getRandomInt(0, OPERATORS.length)];
        int firstNumber = Utils.getRandomInt(0, NUMBER_MAX);
        int secondNumber = Utils.getRandomInt(0, NUMBER_MAX);
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
        return switch (operand) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            default -> throw new RuntimeException("Unsupported operation");
        };
    }
}
