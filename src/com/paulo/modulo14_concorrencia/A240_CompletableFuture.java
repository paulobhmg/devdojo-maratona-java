package com.paulo.modulo14_concorrencia;

import com.paulo.modulo14_concorrencia.domain.ProductStore;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/* Seguindo o conceito de Future, temos também o CompletableFuture, que abstrai ainda mais a complexidade de se trabalhar
   com métodos assíncronos. CompletableFuture utiliza o ForkJoin para executar o trabalho das threads.
   Um detalhe importante é que, apesar de implicitamente trabalhar com um Executor, não é necessário utilizar um diretamente
   para gerar um CompletableFuture.

   Como não depende de um Executor, não é necessário dar o shutdown ou tratar a exeção no método get(), pois ele utiliza
   o método join(), que não necessita de tratamento de exceção e provê código mais limpo. */
public class A240_CompletableFuture {
    public static void main(String[] args) {
        ProductStore product = new ProductStore();

        getPriceSynchronized(product);
        getPriceAsyncWithFuture(product);
        getPriceAsyncWithFutureAllTogether(product);
        getPriceAsyncWithCompletableFuture(product);

        getIncorrectPriceAsyncWithCompletableFuture(product);
        getCorrectPriceAsyncWithCompletableFuture(product);
    }

   /* Exemplo utilizando um método sincronizado.
      O método getPrice() da classe ProductStore cria um delay de 2 segundos para cada thread. Neste caso, ao acessar
      de forma assíncrona normal, cada thread espera o lock por 2s e quanto maior a quantidade de objetos, maior o tempo
      de execução da aplicação. */
    public static void getPriceSynchronized(ProductStore product) {
        long start = System.currentTimeMillis();
        System.out.println(product.getPriceSynchronized("Product 1"));
        System.out.println(product.getPriceSynchronized("Product 2"));
        System.out.println(product.getPriceSynchronized("Product 3"));
        System.out.println(product.getPriceSynchronized("Product 4"));
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }

    /* Utilizando o Future, obtemos o resultado no futuro, ou seja, de forma assíncrona. Contudo, da forma que o código
       abaixo está sendo executado, ao utilizar o método get() diretamente, cada thread aguardará 2s pela execução do
       método get(), então apesar do Future ser assíncrono, a execução da tarefa não será assíncrona. */
    public static void getPriceAsyncWithFuture(ProductStore product) {
        long start = System.currentTimeMillis();
        try {
            System.out.println(product.getPriceAsyncWithFuture("Product 1").get());
            System.out.println(product.getPriceAsyncWithFuture("Product 2").get());
            System.out.println(product.getPriceAsyncWithFuture("Product 3").get());
            System.out.println(product.getPriceAsyncWithFuture("Product 4").get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // product.shutdownExecutor();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }

    /* Já aqui, ainda utilizamos o Future, com a diferença de que todas as Threads são instanciadas ao mesmo momento e
       somente depois é utilizado o método get(). Dessa forma, os resultados são recuperados de forma assíncrona, todos
       de uma só vez. */
    public static void getPriceAsyncWithFutureAllTogether(ProductStore product) {
        long start = System.currentTimeMillis();
        Future<Integer> productFuture1 = product.getPriceAsyncWithFuture("Product 1");
        Future<Integer> productFuture2 = product.getPriceAsyncWithFuture("Product 2");
        Future<Integer> productFuture3 = product.getPriceAsyncWithFuture("Product 3");
        Future<Integer> productFuture4 = product.getPriceAsyncWithFuture("Product 4");
        try {
            System.out.println(productFuture1.get());
            System.out.println(productFuture2.get());
            System.out.println(productFuture3.get());
            System.out.println(productFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            product.shutdownExecutor();
        }

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }

    /* O CompletableFuture funcina basicamente como o Future, com a diferença que não depende de um Executor para sua
       instanciação, portanto não utiliza o método get(), mas sim o join() e não exige o tratamento de exeção ou
       que seja feito o shutdown(). */
    public static void getPriceAsyncWithCompletableFuture(ProductStore product) {
        long start = System.currentTimeMillis();
        CompletableFuture<Integer> complete1 = product.getPriceAsyncWithCompletableFuture("Product 1");
        CompletableFuture<Integer> complete2 = product.getPriceAsyncWithCompletableFuture("Product 2");
        CompletableFuture<Integer> complete3 = product.getPriceAsyncWithCompletableFuture("Product 3");
        CompletableFuture<Integer> complete4 = product.getPriceAsyncWithCompletableFuture("Product 4");
        System.out.println(complete1.join());
        System.out.println(complete2.join());
        System.out.println(complete3.join());
        System.out.println(complete4.join());
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }

    /* Podemos também trabalhar de forma assíncrona a partir de Stream de dados. Dessa forma, assim como nos metodos anteriores,
       e importante se atentar a separaçao da submissao e execuçao do metodo que retorna um Future ou CompletableFuture,
       pois as açoes intermediarias dos Streams sao executadas sequencialmente e neste caso as threads serao executadas
       uma de cada vez. Resumindo, dessa forma nao sera executado de forma assincrona. */
    public static void getIncorrectPriceAsyncWithCompletableFuture(ProductStore product) {
        List<String> stores = List.of("Product 1", "Product 2", "Product 3", "Product 4");
        long start = System.currentTimeMillis();

        stores.stream()
                .map(product::getPriceAsyncWithCompletableFuture)
                .map(CompletableFuture::join)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }

    /* Neste exemplo, a declaraçao da lista de complatableFuture esta separada da execuçao, ou seja, antes de executar
       o join e pegar o resultado contido na lista, o Java ja acionou a trigger de todas as ComplatableFutures que serao
       utilizadas posteriormente. Dessa forma, primeiro obtemos uma lista de CompletableFuture e depois iteramos sobre a lista,
       obtendo o resultado assincrono. */
    public static void getCorrectPriceAsyncWithCompletableFuture(ProductStore product) {
        List<String> stores = List.of("Product 1", "Product 2", "Product 3", "Product 4");
        long start = System.currentTimeMillis();

        List<CompletableFuture<Integer>> collect = stores.stream()
                .map(product::getPriceAsyncWithCompletableFuture)
                .collect(Collectors.toList());
        //collect.forEach(join -> System.out.println(join.join()));
        //collect.stream().map(CompletableFuture::join).forEach(System.out::println);
        List<Integer> collect1 = collect.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("\n" + collect1);

        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end - start));
        System.out.println("------------------------------------------------");
    }
}
