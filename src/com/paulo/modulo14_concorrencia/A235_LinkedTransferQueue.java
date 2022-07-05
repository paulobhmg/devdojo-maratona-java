package com.paulo.modulo14_concorrencia;


import java.util.concurrent.*;

/* A LinkedTransferQueue é uma implementação da interface TransferQueue que permite que sejam feitas operações atômicas
   e concorrêntes, possibilitando travar ou não o lock para aquela coleção. */
public class A235_LinkedTransferQueue {
    public static void main(String[] args) throws InterruptedException {
        // ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue

        TransferQueue<Object> transfer = new LinkedTransferQueue<>(); // Essa coleção tem capacidade limitada fixa.
        System.out.println("Capacity: " + transfer.remainingCapacity());

        // Adiciona um novo item e lança exceção IllegalStatemente caso a lista esteja cheia ou NullPointerException caso item null.
        System.out.println("Add: " + transfer.add("Tiago"));

        // Adiciona um novo item e retorna true ou false, se o item for adicionado ou não.
        System.out.println("Offer without exception: " + transfer.offer("Augusto"));

        // Tenta adicionar um item, esprando 2 segundos caso não tenha espaço, ao final, se não conseguir lança exceção
        System.out.println("Offer with exception: " + transfer.offer("Paulo", 2, TimeUnit.SECONDS));

        // Tenta adicionar um item e se não houver capacidade bloqueia a thread até que tenha espaço na coleção
        transfer.put("Renato");

        /* O método transfer transfere um produto para um consumidor. Esse método irá bloquear a thread em execução até
           que algum consumidor remova o item da lista utilizando o método poll() ou take(). Por isso existe um método que
           verifica se há algum Consumer esperando para consumir o objeto. */
        if(transfer.hasWaitingConsumer()){
            transfer.transfer("Marilene");
        }

        // Tenta transferir imediatamente e se não houver um consumer espeerando, retorna falso.
        System.out.println("Try transfer without wait: " + transfer.tryTransfer("Tiago"));

        // Tenta transferir um objeto para um consumer e espera um tempo para ver se alguém consome, caso contrário retorna falso.
        System.out.println("Try transfer with wait WITH POSSIBLE EXCEPTION: " + transfer.tryTransfer("Paulo", 2, TimeUnit.SECONDS));

        // Pega o elemento da cabeça da coleção e caso a coleção esteja vazia, lança exception
        System.out.println("Get with element(): " + transfer.element());

        // Pega o elemento da cabeça da coleção sem lançar exceção, retornando null caso a coleção esteja vazia.
        System.out.println("Get with peek(): " + transfer.peek());

        // Pega o elemento da cabeça e remove, retornando null caso seja vazio.
        System.out.println("Get and remove with poll() without time or exception: " + transfer.poll());

        // Tenta pegar um elemento e caso esteja vazio, aguarda dois segundos para um possível elemento. Caso não encontre lança exception
        System.out.println("Get and remove with poll() with time and exception: " + transfer.poll(2, TimeUnit.SECONDS));

        // Tenta recuperar um elemento e caso a coleção esteja vazia, bloqueia a thread até que tenha um elemento para ser recuperado.
        System.out.println("Get and remove with take(): " + transfer.take());
    }
}
