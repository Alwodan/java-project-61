package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n0 - Exit");
        int chosenGame = Engine.chooseGame();
        switch (chosenGame) {
            case 1 -> Engine.greeting();
            case 2 -> Engine.gameLoop(2);
            default -> System.exit(0);
        }
    }
}
