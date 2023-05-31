package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Random;

public class Progression {
    public static final String MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int FIRST_NUMBER_MAX = 50;
    private static final int DIFFERENCE_MAX = 20;

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

    public static String generateQuestion() {
        Random random = new Random();
        int firstNumber = random.nextInt(FIRST_NUMBER_MAX);
        //it can't hide the first number
        int numberToHide = random.nextInt(PROGRESSION_LENGTH - 1) + 1;
        int difference = random.nextInt(DIFFERENCE_MAX);
        int currentNumber = firstNumber;
        StringBuilder result = new StringBuilder(String.valueOf(firstNumber));
        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            currentNumber += difference;
            if (i == numberToHide) {
                result.append(" ..");
            } else {
                result.append(" ").append(currentNumber);
            }
        }
        return result.toString();
    }

    public static String generateAnswer(String question) {
        return String.valueOf(getMissingNumber(question));
    }

    private static int getMissingNumber(String numbers) {
        String[] elements = numbers.split(" ");
        int diff;

        if (elements[1].equals("..")) {
            diff = Integer.parseInt(elements[3]) - Integer.parseInt(elements[2]);
        } else {
            diff = Integer.parseInt(elements[1]) - Integer.parseInt(elements[0]);
        }

        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals("..")) {
                return Integer.parseInt(elements[i - 1]) + diff;
            }
        }
        return 0;
    }
}
