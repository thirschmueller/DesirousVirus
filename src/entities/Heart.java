package entities;

import utils.CollisionDetection;

import java.awt.*;

public class Heart {
    
    private final Rectangle r;

    public Heart(final Rectangle r) {
        this.r = r;
    }

    /* tick-Methode, die checkt, ob der Player in der Box ist, wenn ja Ausgabe von Kollision*/
    public boolean isReached(final Player p) {
        return CollisionDetection.collisionCheckSingle(r, p.getBorder());
    }
}
