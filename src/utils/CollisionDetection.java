package utils;

import java.awt.*;

public class CollisionDetection {
    /*Methode prüft ob ein Kollision vorliegt*/
	public static boolean collisionCheckSingle(final Rectangle obj1, final Rectangle obj2) {
        // Position Objekt 1
        double centerX1 = obj1.getCenterX();
        double centerY1 = obj1.getCenterY();

        // Position Objekt 2
        double centerX2 = obj2.getCenterX();
        double centerY2 = obj2.getCenterY();

        // Berechnet die Distanz zwischen den Zentren von Objekt 1 und 2
        double diffX = centerX1 - centerX2;
        double diffY = centerY1 - centerY2;

        double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

        // Vergleicht die minimale Distanz
        double minDistance = obj1.getWidth() / 2 + obj2.getWidth() / 2;
        return distance <= minDistance*0.8;
    }
}
