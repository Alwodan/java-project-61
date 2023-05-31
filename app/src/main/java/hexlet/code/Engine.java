package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_TURNS = 3;
    private static String userName;
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void setUserName() {
        userName = SCANNER.nextLine();
    }

    public static String getUserName() {
        return userName;
    }

    public static boolean handleRound(String question, String correctAnswer) {
        System.out.println("Question: " + question);
        String userAnswer  = SCANNER.nextLine();
        System.out.println("Your answer: " + userAnswer);
        if (userAnswer.equals(correctAnswer)) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
            System.out.println("Let's try again, " + userName + "!");
            return false;
        }
    }

    public static int chooseGame() {
        int choice = SCANNER.nextInt();
        SCANNER.nextLine();
        System.out.println("Your choice: " + choice + "\n");
        return choice;
    }

    public static void sayGoodbye() {
        System.out.println("Congratulations, " + userName + "!");
    }
}
