package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet\n2 - Even\n3 - Calc\n4 - GCD\n0 - Exit");
        int chosenGame = Engine.chooseGame();
        if (chosenGame == 1) {
            Engine.greeting();
        } else if (chosenGame > 1 && chosenGame < 5) {
            Engine.gameLoop(chosenGame);
        }
    }
}
