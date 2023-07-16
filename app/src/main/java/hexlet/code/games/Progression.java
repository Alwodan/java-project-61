package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int FIRST_NUMBER_MAX = 50;
    private static final int DIFFERENCE_MAX = 20;
    private static int indexToHide;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            //I think this solution is pretty garbage
            String[] progression = generateProgression();
            indexToHide = Utils.getRandomInt(0, PROGRESSION_LENGTH);
            //Be careful - answer is generated first in this game
            questionsAndAnswers[i][1] = generateAnswer(progression);
            questionsAndAnswers[i][0] = generateQuestion(progression);
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    private static String[] generateProgression() {
        int difference = Utils.getRandomInt(0, DIFFERENCE_MAX - 1) + 1;
        int currentNumber = Utils.getRandomInt(0, FIRST_NUMBER_MAX);

        String[] numbers = new String[PROGRESSION_LENGTH];
        numbers[0] = String.valueOf(currentNumber);

        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            currentNumber += difference;
            numbers[i] = String.valueOf(currentNumber);
        }

        return numbers;
    }

    public static String generateAnswer(String[] numbers) {
        return numbers[indexToHide];
    }

    private static String generateQuestion(String[] numbers) {
        numbers[indexToHide] = "..";
        return String.join(" ", numbers);
    }
}
