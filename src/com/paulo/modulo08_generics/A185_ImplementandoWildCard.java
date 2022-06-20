package com.paulo.modulo08_generics;

import com.paulo.modulo07_colecoes.domain.Fritante;

import java.util.ArrayList;
import java.util.List;

/* Conforme visto no código sobre a conceituação do WildCard, para a passagem de listas como parâmetros é importante
   utilizar o WildCard para especificar qual tipo de lista é aceita como argumento em métodos.

   O WildCard utilizando o extends possui algumas peculiaridades:
     1 - Quando utilizamos o ? extends, é permitido passar como argumento qualquer tipo de lista que seja um Animal,
         porém, como regra, não é permitido adicionar novos elementos a partir do método utilizado, pois não há como
         saber qual é o tipo de lista que será recebida como argumento, visto que é possível ter inúmeras classes filhas de Animal.
     2 - Podemos utilizar apenas a palavra extends. Não há a possibilidade de utilizar o implements para verificar se a lista
         implementa alguma interface. Mesmo para interface utilizamos extends.

    O WildCard utilzando o super também possui suas peculiadirdades:
      1 - Quando utilizamos o ? super, podemos receber listas de objetos que sejam da mesma classe ou de classes pai, dessa forma
          podemos adicionar objetos, pois temos a garantia do polimorfismo de que um objeto SEMPRE será do tipo da lista ou
          um tipo acima.
          Neste caso, será necessário utilizar o instanceof para validar a possibilidade de o objeto ser
          de um tipo diferente daquele esperado.
      2 - Não é permitido passar listas de classes filhas, pois essa são mais especializadas e poderá haver erros caso seja
          passada uma classe irmã como parâmetro. */
public class A185_ImplementandoWildCard {
    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>(List.of(new Cachorro(), new Cachorro()));
        List<Gato> gatos = new ArrayList<>(List.of(new Gato(), new Gato()));
        List<Animal> animais = new ArrayList<>(List.of(new Cachorro(), new Gato(), new Cachorro(), new Gato()));

     /* Testar código abaixo
        imprimeAnimaisSemAdd(cachorros);
        imprimeAnimaisSemAdd(gatos);
        imprimeAnimaisSemAdd(animais);
      */

      // imprimeAnimaisComAdd(gatos); // Não é possível passar listas mais específicas quando utilizamos o <? super >

        imprimeAnimaisComAdd(animais);
        imprimeAnimaisComAdd(animais);
    }

    public static void imprimeAnimaisSemAdd(List<? extends Animal> lista) {
        for (Animal animal : lista) {
            animal.consultar();
        }

        /* Neste caso, não podemos adicionar um novo objeto, pois não há como saber qual é o tipo que será recebido.
           Utilizando o raciocínio das atribuições abaixo, é possível entender por que não é possível adicionar objetos.

           Cachorro cachorro = new Cachorro() - ok.
           Cachorro gato = new Gato() - não é possível atribuir a cachorro um objeto do tipo Gato
           Cachorro animal = new Animal() - não é possível atribuir um Animal à cachorro, pois Cachorro é mais específico. */

        // lista.add(new Cachorro());
    }

    public static void imprimeAnimaisComAdd(List<? super Animal> lista) {
        // Como a lista pode receber objetos pai da classe esperada, é necessário fazer o casting para validação dos dados.
        for (Object objeto : lista) {
            if(objeto instanceof Cachorro){ // Vamos exibir apenas objetos do tipo Cachorro.
                ((Cachorro ) objeto).consultar();
            }
        }

        lista.add(new Cachorro());
        lista.add(new Gato());
    }
}
