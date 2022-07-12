package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.NewProductStore;
import com.paulo.modulo14_concorrencia.domain.Quote;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A243_NestedCompletableFuture {
    public static void main(String[] args) {
        NewProductStore productStore = new NewProductStore();
        getPriceSync(productStore);
        getPriceAsync(productStore);

    }

    private static void getPriceSync(NewProductStore productStore) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        long start = System.currentTimeMillis();
        stores.stream()
            .map(productStore::getPriceSync)
            .map(Quote::makeQuote)
            .map(productStore::getDiscount)
            .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }

    /* Trabalhando de forma assíncrona */
    private static void getPriceAsync(NewProductStore productStore) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> collect = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> productStore.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::makeQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> productStore.getDiscount(quote))))
                .collect(Collectors.toList());
        collect.forEach(cf -> System.out.println(cf.join()));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }
}
