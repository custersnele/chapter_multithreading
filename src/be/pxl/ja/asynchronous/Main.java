package be.pxl.ja.asynchronous;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

// Enum for money currencies
enum Money {
    EUR, USD
}

// Simulate a shop fetching the price
class Shop {
    public double getPrice(String product) {
        delay();
        // Random price between 50 and 150
        return 50 + ThreadLocalRandom.current().nextDouble() * 100;
    }

    private void delay() {
        try {
            Thread.sleep(1000); // Simulate 1 second delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// Simulate an exchange service fetching the exchange rate
class ExchangeService {
    public double getRate(Money from, Money to) {
        delay();
        if (from == Money.EUR && to == Money.USD) {
            return 1.1; // Example: 1 EUR = 1.1 USD
        } else {
            throw new IllegalArgumentException("Unsupported currency conversion");
        }
    }

    private void delay() {
        try {
            Thread.sleep(500); // Simulate 0.5 second delay
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

// Main class to run everything
public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        ExchangeService exchangeService = new ExchangeService();
        String product = "MacBook Pro";

        long start = System.currentTimeMillis();

        Future<Double> futurePriceInUSD = 
            CompletableFuture.supplyAsync(() -> shop.getPrice(product))
                .thenCombine(
                    CompletableFuture.supplyAsync(() -> exchangeService.getRate(Money.EUR, Money.USD)),
                    (price, rate) -> price * rate
                );

        try {
            // Block and get the final price in USD
            Double priceInUSD = futurePriceInUSD.get();
            System.out.printf("The price of %s in USD is %.2f%n", product, priceInUSD);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        long duration = System.currentTimeMillis() - start;
        System.out.println("Done in " + duration + " ms");
    }
}
