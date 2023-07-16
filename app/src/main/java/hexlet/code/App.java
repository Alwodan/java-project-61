package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final int GREETING = 1;
    private static final int EVEN_GAME = 2;
    private static final int CALC_GAME = 3;
    private static final int GCD_GAME = 4;
    private static final int PROGRESSION_GAME = 5;
    private static final int PRIME_GAME = 6;
    public static void main(String[] args) {
        printMenu();
        launch(chooseGame());
    }

    private static void printMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
    }

    private static int chooseGame() {
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Your choice: " + choice + "\n");
        return choice;
    }

    private static void launch(int chosenGame) {
        switch (chosenGame) {
            case GREETING -> Cli.greeting();
            case EVEN_GAME -> Even.startGame();
            case CALC_GAME -> Calc.startGame();
            case GCD_GAME -> GCD.startGame();
            case PROGRESSION_GAME -> Progression.startGame();
            case PRIME_GAME -> Prime.startGame();
            default -> {
                return;
            }
        }
    }
}
