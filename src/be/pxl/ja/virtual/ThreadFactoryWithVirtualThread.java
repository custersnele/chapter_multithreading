package be.pxl.ja.virtual;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class ThreadFactoryWithVirtualThread {

    public static void main(String[] args) {
        ThreadFactory virtualThreadFactory = Thread.ofVirtual().name("MyVirtualThread-", 0).factory();

        ExecutorService executor =
                Executors.newFixedThreadPool(4, virtualThreadFactory);

        for (int i = 0; i < 8; i++) {
            executor.submit(() -> {
                System.out.println("Running task in a virtual thread: "
                        + Thread.currentThread().getName());
            });
        }

        shutdownAndAwaitTermination(executor);
    }

    private static void shutdownAndAwaitTermination(ExecutorService executorService) {
        executorService.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                    System.err.println("Executor service failed to terminate.");
                }
            }
        } catch (InterruptedException ex) {
            executorService.shutdownNow();       // (Re-)Cancel if current thread also interrupted
            Thread.currentThread().interrupt();           // Preserve interrupt status
        }
    }
}