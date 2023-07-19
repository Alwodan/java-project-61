package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Progression {
    public static final String MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGTH = 10;
    private static final int FIRST_NUMBER_MAX = 50;
    private static final int DIFFERENCE_MAX = 20;

    public static void startGame() {
        String[][] questionsAndAnswers = new String[Engine.NUMBER_OF_TURNS][2];
        for (int i = 0; i < Engine.NUMBER_OF_TURNS; i++) {
            String[] progression = generateProgression(DIFFERENCE_MAX, FIRST_NUMBER_MAX, PROGRESSION_LENGTH);
            int indexToHide = Utils.getRandomInt(0, PROGRESSION_LENGTH);

            //Be careful - answer is generated first in this game
            String answer = progression[indexToHide];
            progression[indexToHide] = "..";
            String question = String.join(" ", progression);

            questionsAndAnswers[i][1] = answer;
            questionsAndAnswers[i][0] = question;
        }
        Engine.handleGame(questionsAndAnswers, MESSAGE);
    }

    private static String[] generateProgression(int maxDifference, int maxFirstNumber, int progressionLength) {
        int difference = Utils.getRandomInt(0, maxDifference - 1) + 1;
        int currentNumber = Utils.getRandomInt(0, maxFirstNumber);

        String[] numbers = new String[progressionLength];
        numbers[0] = String.valueOf(currentNumber);

        for (int i = 1; i < progressionLength; i++) {
            currentNumber += difference;
            numbers[i] = String.valueOf(currentNumber);
        }

        return numbers;
    }
}
