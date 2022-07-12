package behavior;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncTask {
    private static ExecutorService executor = Executors.newFixedThreadPool(10);

    public AsyncTask(final Runnable target) {
        executor.execute(target);
    }

    public synchronized static void stop() {
        executor.shutdown();
        while (!executor.isTerminated()) {
            // wait till all threads are finished
        }
    }
}
