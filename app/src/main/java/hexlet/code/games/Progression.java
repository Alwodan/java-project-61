package hexlet.code.games;

import java.util.Random;

public class Progression {
    private static String currentAnswer;
    public static final String MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int FIRST_NUMBER_MAX = 50;
    private static final int DIFFERENCE_MAX = 20;

    public static String generateQuestion() {
        Random random = new Random();
        int firstNumber = random.nextInt(FIRST_NUMBER_MAX);
        //yeah, it can't hide the first number, that's a shame
        int numberToHide = random.nextInt(PROGRESSION_LENGTH - 1) + 1;
        int difference = random.nextInt(DIFFERENCE_MAX);
        int currentNumber = firstNumber;
        StringBuilder result = new StringBuilder(String.valueOf(firstNumber));
        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            currentNumber += difference;
            if (i == numberToHide) {
                result.append(" ..");
                currentAnswer = String.valueOf(currentNumber);
            } else {
                result.append(" ").append(currentNumber);
            }
        }
        return result.toString();
    }

    public static String generateAnswer() {
        return currentAnswer;
    }
}
