package utils;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {	//performance Verbesserung
    private static final ExecutorService executor = Executors.newFixedThreadPool(ManagementFactory.getThreadMXBean().getThreadCount());	//erstellen von mehreren Threads (ExecutorService managed die Threads)
    private static boolean isRunning;
    
    /* Methode kann hier Ziel der Threads angeben*/
    public static void addTask(final Runnable target) {
        executor.execute(target);
        isRunning = true;
    }

    /* Methode soll alle Threads stoppen, wenn das Spiel geschlossen wird*/
    public static void stop() {	
        executor.shutdownNow();
    //    waitTillTermination();
        isRunning = false;
    }
    
    /* Methode */
    public static void waitTillTermination () {		//synchronized = nicht parallel ausfuehren von dem und den Methoden davor 
        while (!executor.isTerminated()) { 			// wartet bis alle Threads ausgefuehrt haben
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    	
    }
    
    /*Methode gibt zurück, dass das Spiel läuft*/
    public static boolean isRunning () {
    	return isRunning;	
    }
}
