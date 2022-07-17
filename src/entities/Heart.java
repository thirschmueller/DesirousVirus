package entities;

import utils.CollisionDetection;

import java.awt.*;

public class Heart {
    
    private final Rectangle r;

    /* tick-Methode, die checkt, ob der Player in der Box ist --> wenn ja: return true*/
    public Heart(final Rectangle r) {
        this.r = r;
    }

    public boolean isReached(final Player p) {
        return CollisionDetection.collisionCheckSingle(r, p.getBorder());
    }
}
