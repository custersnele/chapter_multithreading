package be.pxl.ja.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Computation3 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int x = 1337;
        long time = System.currentTimeMillis();

        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {

            CompletableFuture<Integer> y = CompletableFuture.supplyAsync(() -> f(x), executorService);
            CompletableFuture<Integer> z = CompletableFuture.supplyAsync(() -> g(x), executorService);

            // Combine both results
            CompletableFuture<Integer> result = y.thenCombine(z, Integer::sum);

            System.out.println(result.join()); // join waits and gets the final result
        }

        System.out.println(System.currentTimeMillis() - time);
    }

    private static int g(int x) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x * 3;
    }

    private static int f(int x) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return x * 2;
    }
}
