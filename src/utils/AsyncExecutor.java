package utils;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncExecutor {	//performance Verbesserung
    private static final ExecutorService executor = Executors.newFixedThreadPool(ManagementFactory.getThreadMXBean().getThreadCount());	//erstellen von mehreren Threads(ExecutorService managed die Threads)
    private static boolean isRunning;
    
    public static void addTask(final Runnable target) { // ziel der threads kann hierüber angegeben werden (Runnable sorgt dafür, dass etwas ausführbar ist --> muss dann überschrieben werden)
        executor.execute(target);
        isRunning = true;
    }

    public static void stop() {	//wenn das spiel geschlossen wird, sollen alle threads gestoppt werden 
        executor.shutdownNow();
    //    waitTillTermination();
        isRunning = false;
    }
    
    public static void waitTillTermination () {	//synchronized = nicht parallel ausführen von dem und den Methoden davor 
        while (!executor.isTerminated()) { // wait till all threads are finished
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    	
    }
    
    public static boolean isRunning () {
    	return isRunning;	
    }
}
