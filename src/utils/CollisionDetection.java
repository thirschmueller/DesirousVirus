package utils;

import java.awt.*;

public class CollisionDetection {
    public static boolean collisionCheckSingle(final Rectangle obj1, final Rectangle obj2) {	//kolision detection
        // Location obj 1
        double centerX1 = obj1.getCenterX();
        double centerY1 = obj1.getCenterY();

        // Location obj 1
        double centerX2 = obj2.getCenterX();
        double centerY2 = obj2.getCenterY();

        // Calculate the distance between the center of obj1 and obj2
        double diffX = centerX1 - centerX2;
        double diffY = centerY1 - centerY2;

        double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));

        // Compare with minimum distance
        double minDistance = obj1.getWidth() / 2 + obj2.getWidth() / 2;
        return distance <= minDistance*0.8;
    }
}
