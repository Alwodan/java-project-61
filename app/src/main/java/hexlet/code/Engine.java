package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_TURNS = 3;

    public static void handleGame(String[][] questionAndAnswer, String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        String username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
        System.out.println(message);

        for (int i = 0; i < NUMBER_OF_TURNS; i++) {
            System.out.println("Question: " + questionAndAnswer[i][0]);
            String userAnswer  = scanner.nextLine();
            System.out.println("Your answer: " + userAnswer);
            if (userAnswer.equals(questionAndAnswer[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '"
                        + questionAndAnswer[i][1] + "'");
                System.out.println("Let's try again, " + username + "!");
                return;
            }
        }
        System.out.println("Congratulations, " + username + "!");
    }
}
