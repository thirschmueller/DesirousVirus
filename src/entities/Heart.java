package entities;

import utils.CollisionDetection;

import java.awt.*;

public class Heart {
    // tick method, die ckecke ob der Player in der Box ist --> return true
    private final Rectangle r;

    public Heart(final Rectangle r) {
        this.r = r;
    }

    public boolean isReached(final Player p) {
        return CollisionDetection.collisionCheckSingle(r, p.getBorder());
    }
}
