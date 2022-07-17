package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {	//performance Verbesserung
    private static final ExecutorService executor = Executors.newFixedThreadPool(10);	//erstellen von mehreren Threads(ExecutorService managed die Threads)

    public synchronized static void addTask(final Runnable target) { // ziel der threads kann hierüber angegeben werden (Runnable sorgt dafür, dass etwas ausführbar ist --> muss dann überschrieben werden)
        executor.execute(target);
    }

    public synchronized static void stop() {	//wenn das spiel geschlossen wird, sollen alle threads gestoppt werden 
        executor.shutdown();
        while (!executor.isTerminated()) { // wait till all threads are finished
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
