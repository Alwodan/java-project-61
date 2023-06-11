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

    public static boolean handleGame(String[][] questionAndAnswer) {
        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            System.out.println("Question: " + questionAndAnswer[i][0]);
            String userAnswer  = SCANNER.nextLine();
            System.out.println("Your answer: " + userAnswer);
            if (userAnswer.equals(questionAndAnswer[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndAnswer[i][1] + "'");
                System.out.println("Let's try again, " + userName + "!");
                return false;
            }
        }
        return true;
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
