package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.NewProductStore;
import com.paulo.modulo14_concorrencia.domain.Quote;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class A243_AllOfAndAnyOf {
    public static void main(String[] args) {
        NewProductStore productStore = new NewProductStore();
        getPriceAsync(productStore);
    }

    private static void getPriceAsync(NewProductStore productStore) {
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        long start = System.currentTimeMillis();
        var completableFutureStream = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> productStore.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::makeQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> productStore.getDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %dms.\n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        // Utilizamos o allOf quando queremos saber se todas a threads de um completableFuture já foram executadas.
        //CompletableFuture<Void> completableVoid = CompletableFuture.allOf(completableFutureStream);

        /* Utilizamos o anyOf quando não precisamos que todas as tarefas sejam finalizadas. Neste caso, quando um dos
           primeiros completableFutures do array for executado, o processamento será finalizado, não nacessitando
           passar por todos os outros. */
        CompletableFuture<Object> completableVoid = CompletableFuture.anyOf(completableFutureStream);
        completableVoid.join();
        System.out.printf("Fineshed? %b\n", completableVoid.isDone());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("--------------------------------");
    }
}
