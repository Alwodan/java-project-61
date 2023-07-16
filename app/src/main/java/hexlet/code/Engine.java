package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int NUMBER_OF_TURNS = 3;

    public static void handleGame(String[][] questionAndAnswer, String message) {
        Scanner scanner = new Scanner(System.in);
        Cli.greeting();
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
                System.out.println("Let's try again, " + Cli.getUsername() + "!");
                return;
            }
        }
        sayGoodbye();
    }

    public static void sayGoodbye() {
        System.out.println("Congratulations, " + Cli.getUsername() + "!");
    }
}
