package com.paulo.modulo08_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class Animal {
    abstract void consultar();
}

class Cachorro extends Animal {
    @Override
    public void consultar() {
        System.out.println("Consultando cachorro...");
    }
}

class Gato extends Animal {
    @Override
    public void consultar() {
        System.out.println("Consultando gato...");
    }
}

public class A184_WildCardConceito {
    public static void main(String[] args) {
        Cachorro[] dogs = { new Cachorro(), new Cachorro() };
        Gato[] cats = { new Gato(), new Gato() };

        // imprimeConsultasArray(dogs);

        List<Cachorro> dogsList = new ArrayList<>(Arrays.asList(dogs));

        /* Devido ao conceito de type ereasure, quando compilamos um código o Java remove a tipagem da lista. Sendo assim,
           quando passamos uma lista como argumento, a lista deverá ter exatamente o mesmo tipo da lista que o parâmetro está
           pedindo. Por exemplo, o método abaixo recebe como argumento uma lista de Animal. Um cachorro é um animal, mas
           uma lista de cachorros não é uma lista de animal, logo, em tempo de compilação essa lista não é aceita como
           argumento para o método. Para resolver isso, utilizamos o WildCard NA DEFINIÇÃO DO MÉTODO, fazendo com que
           sejam aceitos como parâmetros listas de objetos que sejam filhos de Animal. */

        // imprimeConsultasLista(dogsList);
    }

    public static void imprimeConsultasArray(Animal[] animals) {
        for (Animal animal : animals) {
            animal.consultar();
        }

        /* Quando passamos Arrays como parâmetros, em tempo de EXECUÇÃO, o Java sabe exatamente qual é o tipo do array
           que está recebendo. Sendo assim, mesmo que estejamos recebendo um array de Animal, caso o array passado como
           parâmetro seja um Array de gatos, não é possível adicionar um Objeto do tipo Cachorro, pois o Java sabe que
           aquele Array é do tipo Gato. Logo, o código abaixo compila, mas não executa, gerando ArrayStoreException. */

        animals[0] = new Gato(); // Não funciona pois o array recebido como parâmetro é do tipo cachorro.
    }

    // Devido ao conceito de type ereasure, uma lista de objetos filhos não é aceita como argumento neste método.
    public static void imprimeConsultasLista(List<Animal> animals) {
        for(Animal animal : animals) {
            animal.consultar();
        }
    }
}
