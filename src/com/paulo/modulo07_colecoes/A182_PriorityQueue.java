package com.paulo.modulo07_colecoes;

import java.util.PriorityQueue;
import java.util.Queue;

/* Um Queue eh uma fila e sua implementaçao PriorityQueue, como o nome ja diz, eh uma Fila prioritaria.
   Essa implementaçao exige que seus membros sejam Comparable ou que seja passado como argumento um Comparator no construtor.

   Essa coleçao define uma regra de prioridade, organizando seus itens assim como um TreeSet. */
public class A182_PriorityQueue {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("A");
        fila.add("C");
        fila.add("E");
        fila.add("B");
        fila.add("D");

        /* Quando utilizamos uma fila em memória, a ordem dela não necessariamente será a mesma definida por sua organização,
           mas quando recuperamos esses dados, a coleção virá ordenada conforme regra definida. */
        System.out.println(fila);

        /* Para fila, utilizamos basicamente os métodos add(), peek() e poll()
           peek() retorna o próximo item da fila, porém não remove da lista
           poll() retorna o próximo item da fila, removendo-o.
         */

        String proximoItemVisualizado = fila.peek();
        String proximoItemRemovido = fila.poll();

        // Aqui, quando manipulamos a fila de fato, a ordem que os objetos são removidos segue a prioridade definida.
        while(!fila.isEmpty()) {
            System.out.printf("%s, ", fila.poll());
        }
        System.out.println();
    }
}
