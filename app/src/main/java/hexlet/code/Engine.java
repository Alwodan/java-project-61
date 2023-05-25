package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;

import java.util.Scanner;

public class Engine {
    private static final int NUMBER_OF_TURNS = 3;
    public static String userName;
    public static Scanner scanner = new Scanner(System.in);

    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");
    }

    public static void gameLoop(int gameNumber) {
        greeting();
        printMessage(gameNumber);
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            switch (gameNumber) {
                case 2 -> handleRound(Even.generateQuestion(), Even.generateAnswer());
                case 3 -> handleRound(Calc.generateQuestion(), Calc.generateAnswer());
                case 4 -> handleRound(GCD.generateQuestion(), GCD.generateAnswer());
            }
        }
        sayGoodbye();
    }

    public static void handleRound(String question, String correctAnswer) {
        System.out.println("Question: " + question);
        String userAnswer  = scanner.nextLine();
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
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Your choice: " + choice + "\n");
        return choice;
    }

    private static void sayGoodbye() {
        System.out.println("Congratulations, " + userName + "!");
    }

    private static void printMessage(int gameNumber) {
        switch (gameNumber) {
            case 2 -> System.out.println(Even.MESSAGE);
            case 3 -> System.out.println(Calc.MESSAGE);
            case 4 -> System.out.println(GCD.MESSAGE);
        }
    }
}
