package be.pxl.ja.asynchronous;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Computation2 {

        public static void main(String[] args) throws InterruptedException, ExecutionException {
            int x = 1337;
            long time = System.currentTimeMillis();
            try (ExecutorService executorService = Executors.newFixedThreadPool(2);) {
                Future<Integer> y = executorService.submit(() -> f(x));
                Future<Integer> z = executorService.submit(() -> g(x));
                System.out.println(y.get() + z.get());
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
