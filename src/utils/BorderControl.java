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

    private List<BorderCrossed> relativeLocation(final IGameObject object) {
        final List<BorderCrossed> crossed = new ArrayList<>();
        //System.out.println("OBJECT: x: " + object.getX() + ", y:" + object.getY() + ", width:" + object.getWidth() + ", height:" + object.getHeight());
        //System.out.println("BORDER: x: " + border.getX() + ", y:" + border.getY() + ", width:" + border.getWidth() + ", height:" + border.getHeight());

        if (object.getX() < border.getX()) {
            crossed.add(BorderCrossed.LEFT);
        }
        if (object.getY() < border.getY()) {
            crossed.add(BorderCrossed.TOP);
        }
        if (object.getX() + object.getBorder().getWidth() > border.getX() + border.getWidth()) {
            crossed.add(BorderCrossed.RIGHT);
        }
        if (object.getY() + object.getBorder().getHeight() > border.getY() + border.getHeight()) {
            crossed.add(BorderCrossed.BOTTOM);
        }
        return crossed;
    }

    public boolean isColliding(final IGameObject object) {
        final List<BorderCrossed> crossed = relativeLocation(object);
        return crossed.size() != 0;
    }

    public void forceInBorders(final IGameObject object) {
        final List<BorderCrossed> crossed = relativeLocation(object);
        if (crossed.contains(BorderCrossed.LEFT)) {
            object.setVelX(0);
            object.setX(border.getX());
        }
        if (crossed.contains(BorderCrossed.TOP)) {
            object.setVelY(0);
            object.setY(border.getY());
        }
        if (crossed.contains(BorderCrossed.RIGHT)) {
            object.setVelX(0);
            object.setX(border.getX() + border.getWidth() - object.getBorder().getWidth());
        }
        if (crossed.contains(BorderCrossed.BOTTOM)) {
            object.setVelY(0);
            object.setY(border.getY() + border.getHeight() - object.getBorder().getHeight());
        }
    }
}

enum BorderCrossed {
    LEFT,
    TOP,
    RIGHT,
    BOTTOM
}
