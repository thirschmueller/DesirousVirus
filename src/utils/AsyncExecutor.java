package utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {	//performance Verbesserung
	private static final ExecutorService executor = Executors.newFixedThreadPool(10);	//erstellen von mehreren Threads (ExecutorService managed die Threads)
    private static boolean isRunning;
    
    /* Methode kann hier Ziel der Threads angeben*/
    public synchronized static void addTask(final Runnable target) {
    	executor.execute(target);
    }

    /* Methode soll alle Threads stoppen, wenn das Spiel geschlossen wird*/
    public synchronized static void stop() {
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


