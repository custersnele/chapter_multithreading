package be.pxl.ja.asynchronous;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureDemo {

    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> "Hello")
                .thenApplyAsync(str -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return str + " World"; })
                .thenAcceptAsync(System.out::println);
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
