package hexlet.code;

public class Cli {
    public static void greeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Engine.setUserName();
        System.out.println("Hello, " + Engine.getUserName() + "!");
    }
}
