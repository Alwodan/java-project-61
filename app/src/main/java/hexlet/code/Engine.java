package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    private static final int NUMBER_OF_TURNS = 3;
    private static String userName;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        userName = SCANNER.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void gameLoop(int gameNumber) {
        greeting();
        printMessage(gameNumber);
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            switch (gameNumber) {
                case EVEN_GAME -> handleRound(Even.generateQuestion(), Even.generateAnswer());
                case CALC_GAME -> handleRound(Calc.generateQuestion(), Calc.generateAnswer());
                case GCD_GAME -> handleRound(GCD.generateQuestion(), GCD.generateAnswer());
                case PROGRESSION_GAME -> handleRound(Progression.generateQuestion(), Progression.generateAnswer());
                case PRIME_GAME -> handleRound(Prime.generateQuestion(), Prime.generateAnswer());
                default -> System.exit(0);
            }
        }
        sayGoodbye();
    }

    public static void handleRound(String question, String correctAnswer) {
        System.out.println("Question: " + question);
        String userAnswer  = SCANNER.nextLine();
        System.out.println("Your answer: " + userAnswer);
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
            System.out.println("Let's try again, " + userName + "!");
            System.exit(0);
        }
    }

    public static int chooseGame() {
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println("Your choice: " + choice + "\n");
        return choice;
    }

    private static void sayGoodbye() {
        System.out.println("Congratulations, " + userName + "!");
    }

    private static void printMessage(int gameNumber) {
        switch (gameNumber) {
            case EVEN_GAME -> System.out.println(Even.MESSAGE);
            case CALC_GAME -> System.out.println(Calc.MESSAGE);
            case GCD_GAME -> System.out.println(GCD.MESSAGE);
            case PROGRESSION_GAME -> System.out.println(Progression.MESSAGE);
            case PRIME_GAME -> System.out.println(Prime.MESSAGE);
            default -> System.exit(0);
        }
    }
}
