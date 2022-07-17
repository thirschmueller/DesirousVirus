package entities;

import utils.AsyncExecutor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EnemySpawnerDelegator {
	private final List<EnemySpawner> spawners = new ArrayList<>();

    /* Methode erstellt neuen Thread fuer spawner*/
    public void addSpawner(final EnemySpawner e) {	
        spawners.add(e);
        AsyncExecutor.addTask(e);
    }

    /* Methode erstellt neuen Thread fuer render*/
    public void render(final Graphics g) {	
        for (final EnemySpawner e : spawners) {
            e.render(g);
        }
    }

    /* Methode erstellt neuen Thread fuer tick*/
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
