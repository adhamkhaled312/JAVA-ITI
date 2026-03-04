package gov.iti.jets.util;

import java.util.Random;

public class RandomUtil {

    public int generateRandom(int range) {
        Random rand = new Random();
        return rand.nextInt(range) + 1;
    }
}