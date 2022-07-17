package utils;

import entities.IGameObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BorderControl {

    private final Rectangle border;

    public BorderControl(final Rectangle border) {
        this.border = border;
    }

    /* Methode, die angibt, wo der Spieler den validen Bereich ueberschreitet. 
     * Dazu werden die Ecken und Kombinationen dieser genutzt, die außerhalb des invaliden Bereichs liegen*/
    private List<BorderCrossed> bordersCrossed(final IGameObject object) {
        final List<BorderCrossed> crossed = new ArrayList<>();

        final boolean containsTopLeft = border.contains(object.getX(), object.getY()); //obere linke Ecke
        final boolean containsTopRight = border.contains(object.getX() + object.getBorder().getWidth(), object.getY()); //obere rechte Ecke
        final boolean containsBottomLeft = border.contains(object.getX(), object.getY() + object.getBorder().getHeight()); //untere linke Ecke
        final boolean containsBottomRight = border.contains(object.getX() + object.getBorder().getWidth(), object.getY() + object.getBorder().getHeight()); //untere rechte Ecke

        if (containsTopRight && containsBottomRight) { //oben rechts + unten rechts
            crossed.add(BorderCrossed.LEFT);			// --> links überschritten
            return crossed;
        }
        if (containsBottomLeft && containsBottomRight) { //unten links + unten rechts 
            crossed.add(BorderCrossed.TOP);				// --> oben überschritten
            return crossed;
        }
        if (containsTopLeft && containsBottomLeft) { //oben links + unten links
            crossed.add(BorderCrossed.RIGHT);		// --> rechts überschritten
            return crossed;
        }
        if (containsTopLeft && containsTopRight) { //oben links + oben rechts
            crossed.add(BorderCrossed.BOTTOM); 		// --> unten überschritten
            return crossed;
        }

        if (containsTopRight || containsBottomRight) { //oben rechts oder unten rechts
            crossed.add(BorderCrossed.LEFT);
        }
        if (containsBottomLeft || containsBottomRight) { //unten links oder unten rechts 
            crossed.add(BorderCrossed.TOP);
        }
        if (containsTopLeft || containsBottomLeft) { //oben links oder unten links
            crossed.add(BorderCrossed.RIGHT);
        }
        if (containsTopLeft || containsTopRight) { //oben links oder oben rechts
            crossed.add(BorderCrossed.BOTTOM);
        }
        return crossed;
    }

    /* Methode setzt den Spieler wieder in den validen Bereich, je nach dem, wo er den Bereich überschritten hat. 
     * Der Spieler wird dann um die gleiche Distanz in die entgegengesetzte Richtung gesetzt.*/
    public void forceOutOfArea(final IGameObject object) {
        final List<BorderCrossed> crossed = bordersCrossed(object);
        if (crossed.contains(BorderCrossed.LEFT)) {
            object.setVelX(0);
            object.setX(border.getX() - object.getBorder().getWidth() - 1);
        }
        if (crossed.contains(BorderCrossed.TOP)) {
            object.setVelY(0);
            object.setY(border.getY() - object.getBorder().getHeight() - 1);
        }
        if (crossed.contains(BorderCrossed.RIGHT)) {
            object.setVelX(0);
            object.setX(border.getX() + border.getWidth() + 1);
        }
        if (crossed.contains(BorderCrossed.BOTTOM)) {
            object.setVelY(0);
            object.setY(border.getY() + border.getHeight() + 1);
        }
    }

    private enum BorderCrossed {
        LEFT,
        TOP,
        RIGHT,
        BOTTOM
    }
}
