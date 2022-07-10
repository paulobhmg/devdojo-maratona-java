package com.paulo.modulo14_concorrencia.domain;

import java.util.concurrent.*;

public class ProductStore {
    private ExecutorService executor = Executors.newCachedThreadPool();
    public int getPriceSynchronized(String product) {
        System.out.printf("%s started synchronized for %s: ", Thread.currentThread().getName(), product);
        return getPrice();
    }

    public Future<Integer> getPriceAsyncWithFuture(String product) {
        System.out.printf("%s started synchronized with future for %s: ", Thread.currentThread().getName(), product);
        return executor.submit(this::getPrice);
    }

    public CompletableFuture<Integer> getPriceAsyncWithCompletableFuture(String product){
        System.out.printf("%s started synchronized with completable future for %s: ", Thread.currentThread().getName(), product);
        return CompletableFuture.supplyAsync(this::getPrice);
    }

    public int getPrice () {
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }

    public void delay () {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
