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

    private List<BorderCrossed> bordersCrossed(final IGameObject object) {
        final List<BorderCrossed> crossed = new ArrayList<>();

        final boolean containsTopLeft = border.contains(object.getX(), object.getY());
        final boolean containsTopRight = border.contains(object.getX() + object.getBorder().getWidth(), object.getY());
        final boolean containsBottomLeft = border.contains(object.getX(), object.getY() + object.getBorder().getHeight());
        final boolean containsBottomRight = border.contains(object.getX() + object.getBorder().getWidth(), object.getY() + object.getBorder().getHeight());

        if (containsTopRight && containsBottomRight) {
            crossed.add(BorderCrossed.LEFT);
            return crossed;
        }
        if (containsBottomLeft && containsBottomRight) {
            crossed.add(BorderCrossed.TOP);
            return crossed;
        }
        if (containsTopLeft && containsBottomLeft) {
            crossed.add(BorderCrossed.RIGHT);
            return crossed;
        }
        if (containsTopLeft && containsTopRight) {
            crossed.add(BorderCrossed.BOTTOM);
            return crossed;
        }

        if (containsTopRight || containsBottomRight) {
            crossed.add(BorderCrossed.LEFT);
        }
        if (containsBottomLeft || containsBottomRight) {
            crossed.add(BorderCrossed.TOP);
        }
        if (containsTopLeft || containsBottomLeft) {
            crossed.add(BorderCrossed.RIGHT);
        }
        if (containsTopLeft || containsTopRight) {
            crossed.add(BorderCrossed.BOTTOM);
        }
        return crossed;
    }

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
