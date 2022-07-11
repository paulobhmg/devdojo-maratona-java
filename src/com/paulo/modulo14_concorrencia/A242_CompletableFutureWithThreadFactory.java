package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.ProductStore;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/* Quando precisamos trabalhar de forma assíncrona mas não temos total acesso sobre a classe, por exemplo, temos acesso
   apenas ao método que trabalha de forma síncrona, podemos utilizar um supllier nas classe Future e CompletableFuture,
   fazendo com que elas funcionem de forma assíncrona.

   Também podemos alterar o comportamento do ThreadPool, sobrescrevendo a forma como uma thread deverá ser criada, através
   de um ThreadFactory, passado como segundo parâmetro do método supplyAsync();  */
public class A242_CompletableFutureWithThreadFactory {
    public static void main(String[] args) {
        ProductStore product = new ProductStore();

        getAsync(product);
        getAsyncWithExecutor(product);
        getAsyncWithChangedExecutorComportament(product);
    }

    public static void getAsync(ProductStore productStore) {
        List<String> products = List.of("Product 1", "Product 2", "Product 3", "Product 4");
        long start = System.currentTimeMillis();

        List<CompletableFuture<Integer>> collect = products.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> productStore.getPriceSynchronized(s)))
                .collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Executando assíncronicamente: " + collect1);

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }

    public static void getAsyncWithExecutor(ProductStore productStore) {
        List<String> products = List.of("Product 1", "Product 2", "Product 3", "Product 4");
        ExecutorService executor = Executors.newCachedThreadPool();

        long start = System.currentTimeMillis();

        List<CompletableFuture<Integer>> collect = products.stream()
                .map(s -> CompletableFuture.supplyAsync(productStore::getPrice, executor))
                .collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Running asynchronized: " + collect1);
        executor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }

    public static void getAsyncWithChangedExecutorComportament(ProductStore productStore) {
        List<String> products = List.of("Product 1", "Product 2", "Product 3", "Product 4");

       ExecutorService executor = Executors.newCachedThreadPool(r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        long start = System.currentTimeMillis();

        List<CompletableFuture<Integer>> collect = products.stream()
                .map(s -> CompletableFuture.supplyAsync(productStore::getPrice, executor))
                .collect(Collectors.toList());
        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Running asynchronized: " + collect1);
        executor.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }
}
