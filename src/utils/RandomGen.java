package utils;

import java.util.Random;

public class RandomGen {
	/* Methode generiert randomisierte Werte*/
    public static double randomBetween(final double min, final double max) {
        final Random r = new Random();
        return r.nextDouble() * (max - min + 1.0) + min;
    }
}
