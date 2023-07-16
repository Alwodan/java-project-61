package hexlet.code;

import java.util.Random;

public class Utils {

    public static int getRandomInt(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(lowerBound, upperBound);
    }
}
