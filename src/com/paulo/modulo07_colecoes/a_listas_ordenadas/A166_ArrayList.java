package com.paulo.modulo07_colecoes.a_listas_ordenadas;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

/* A interface List provê implementações indexadas. Uma dessas implementações é o ArrayList */
public class A166_ArrayList {
    public static void main(String[] args) {
        List<String> familia = new ArrayList<>();

        familia.add("Marilene");
        familia.add("Ronaldo");
        familia.add("Tiago");
        familia.add("Renato");
        familia.add("Augusto");
        familia.add("Matheus");
        familia.add("Stella");
        familia.add("Miguel");
        familia.add("Hellen");
        familia.add("Dayanne");
        familia.add("Seu Jorge");
        familia.add("Luciana");
        familia.add("Nadille");
        familia.add("Paulo");

        for(String membro : familia) {
            System.out.println(membro);
        }
        System.out.println("-----------------------");

        /* Quando utilizamos o forEach(), como o do exemplo abaixo, o Java utiliza como parâmetro o tamanho total da lista.
           Sendo assim, não é possível adicionar ou remover um item da lista utilizando esse laço, pois obteremos uma exceção
           ConcurentModificationException, pois neste caso, estamos tentando alterar o tamanho do array, que já está
           predefinido pelo laço. Neste caso, o primeiro item será adicionado ao laço e é exatamente por esse motivo
           que obtemos a exceção, pois ao adicionar um novo item, o tamanho da lista definida no laço foi alterado. */
        try{
            for(String membro : familia) {
                familia.remove(membro);
            }
        } catch(ConcurrentModificationException e) {
            System.out.println("Não é possível alterar a lista durante a execução do laço.");
        }
        System.out.println("-----------------------");

        /* Como outro exemplo, podemos utilizar o laço indexado, mas podemos perceber que, se utilizarmos como parâmetro
           o tamanho da lista, a cada volta do laço o tamanho irá aumentar. Sendo assim, obteremos um laço infinito e
           vários dados serão adicionados à lista. */
        for(int i = 0; i < familia.size(); i ++) {
            if(familia.size() == 20) {
                break;
            }
            familia.add("New");
        }

        System.out.println(familia);

        /* Para manipular uma lista durante um laço, é necessário utilizar um objeto Iterator, obtido através da própria
           lista. A partir desse objeto podemos adicionar, remover e manipular itens da lista. */

        // Para remover um item da lista, utilizamos o método remove(), que retorna true ou false, caso tenha removido da lista
        familia.remove("Teste");
        System.out.println(familia);
    }
}
