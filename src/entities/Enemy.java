package entities;

import java.awt.Image;
import java.awt.Shape;
import java.util.Random;

public class Enemy {

	private static void RandomNumber() {

		Random number = new Random();
		int n = number.nextInt(5); // Zuf�llige Zahlen von 0-4, denn 5 Eing�nge von denen Leukozyten kommen

		String[] leukocytes = new String[5];			// zufällige nummer, die die Position zuweist 
		leukocytes[0] = "leukocyte1";
		leukocytes[1] = "leukocyte2";
		leukocytes[2] = "leukocyte3";
		leukocytes[3] = "leukocyte4";
		leukocytes[4] = "leukocyte5";

	}
}

