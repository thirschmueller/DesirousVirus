package behavior;

import entities.EnemySpawner;
import entities.Player;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemySpawnerDelegator {
    private List<EnemySpawner> spawners = new ArrayList<>();

    public void addSpawner(final EnemySpawner e) {	//neuer Thread für spawner
        spawners.add(e);
        new AsyncTask(e);	
    }

    public void render(final Graphics g) {	//neuer Thread für render
        for (final EnemySpawner e : spawners) {
            e.render(g);
        }
    }

    public boolean tick(final Player p) {	//neuer Thread für tick
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
