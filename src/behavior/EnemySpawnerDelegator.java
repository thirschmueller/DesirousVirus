package behavior;

import entities.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemySpawnerDelegator {
    private List<EnemySpawner> spawners = new ArrayList<>();

    public void addSpawner(final EnemySpawner e) {
        spawners.add(e);
        new AsyncTask(e);
    }

    public void render(final Graphics g) {
        for (final EnemySpawner e : spawners) {
            e.render(g);
        }
    }

    public boolean tick(final Player p) {
        boolean hit = false;
        for (final EnemySpawner e : spawners) {
            if (e.tick(p)) {
                hit = true;
                break;
            }
        }
        return hit;
    }
}
