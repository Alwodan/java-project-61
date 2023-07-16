package hexlet.code;

import java.util.Scanner;

public class Cli {
    static String username;

    public static void greeting() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");
    }
}
