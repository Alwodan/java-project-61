package hexlet.code;

public class App {
    private static final int NUMBER_OF_OPTIONS = 7;
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");
        int chosenGame = Engine.chooseGame();
        if (chosenGame == 1) {
            Engine.greeting();
        } else if (chosenGame > 1 && chosenGame < NUMBER_OF_OPTIONS) {
            Engine.gameLoop(chosenGame);
        }
    }
}
