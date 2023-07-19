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
            String operand = OPERATORS[Utils.getRandomInt(0, OPERATORS.length)];
            int firstNumber = Utils.getRandomInt(0, NUMBER_MAX);
            int secondNumber = Utils.getRandomInt(0, NUMBER_MAX);

            String question = firstNumber + " " + operand + " " + secondNumber;
            String answer = String.valueOf(getResult(firstNumber, secondNumber, operand));

            questionsAndAnswers[i][0] = question;
            questionsAndAnswers[i][1] = answer;
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
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
