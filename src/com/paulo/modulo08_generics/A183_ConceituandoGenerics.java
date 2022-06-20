package com.paulo.modulo08_generics;

import com.paulo.modulo07_colecoes.domain.Fritante;

import java.util.ArrayList;
import java.util.List;

/* Generics foi introduzido ao Java com a proposta de minimizar possíveis erros ocasionados por uso de dados incorretos,
   como em listas por exemplo. Dessa forma, o generics faz com que em tempo de compilação um objeto não possa ser
   adicionado em uma lista cujo tipo de sua definiçaõ é diferente do tipo do objeto.

   Já em tempo de execução, acontece o que é conhecido como type ereasure, ou seja, quando o código é executado, o bytecode
   gerado pelo compilador apaga o tipo definido no generics. Isso é necessário para manter a compatibilidade entre as
   versões anteriores, que não utilizam esse recurso.  */
public class A183_ConceituandoGenerics {
    public static void main(String[] args) {
        String nome = "Paulo";
        Long idade = 29L;
        Double salario = 8000.0;
        Fritante fritante = new Fritante(nome);

        /* Antigamente, uma lista poderia ser definida de forma genérica e o método add() adicionava um objeto de qualquer
           tipo, permitindo que vários tipos diferentes de objetos pudessem ser armazenados na mesma lista.
           ** Obs: O type ereasure faz com que a lista seja salva exatamente como abaixo, no arquivo .class */
        List listaSemGenerics = new ArrayList(List.of(nome, idade, salario, fritante));
        System.out.println(listaSemGenerics);

        /* Para percorrer essa lista, não podemos simplesmente fazer um for e recuperar objetos, pois não há como saber
           quais são os tipos de dados que estão presentes nela, tendo em vista que o add() recebe um Object, que pode
           ser qualquer coisa. No exemplo abaixo, conseguimos percorrer a lista e exibir os valores, pois o valor
           está sendo impresso com base no index da lista, e não pelo tipo de dado. */
        System.out.print("Percorrendo lista por index: ");
        for(int i = 0; i < listaSemGenerics.size(); i++) {
            System.out.print(listaSemGenerics.get(i) + ", ");
        }
        System.out.println("\n----------------------------");

        /* Já nesse exemplo, não é possível especificar um tipo de dado, pois uma lista criada sem Generics, recebe um objeto,
           logo, não há como fazer um forEach utilizando uma variável de tipo String como referência.

            for(String item : listaSemGenerics) {
                System.out.println(item);
            } */

        System.out.print("Percorrendo lista genérica por objeto: ");
        for (Object o : listaSemGenerics){
            System.out.print(o + ", ");
        }
        System.out.println("\n----------------------------");

        // Com base no resultado do último código, podemos perceber que é necessário efetuar o cast dos dados ao percorrer a lista.
        System.out.println("Percorrendo lista genérica fazendo casting: ");
        for(Object o : listaSemGenerics){
            if(o instanceof String){
                System.out.printf("%s, ", o);
            } else if(o instanceof Long) {
                System.out.printf("%d anos, ", o);
            } else if(o instanceof Double) {
                System.out.printf("Salário: R$ %.2f, ", o);
            } else if(o instanceof Fritante) {
                System.out.printf("Fritante: %s.", ((Fritante) o).getNome());
            }
        }
        System.out.println("\n----------------------------");

        // Devido a esses fatos, surgiu o Generics. Com ele, em tempo de compilação é verificado se o dado é do mesmo tipo da lista.
        List<String> listaComGenerics = new ArrayList<>(List.of("Paulo", "Tiago", "Renato", "Augusto", "Marilene"));
        System.out.println("Lista com genérics: " + listaComGenerics);
        System.out.println("----------------------------");

        /* Uma observação muito importante em relação ao conceito do Generics é que, caso tenhamos um método que adiciona
           um item em uma lista passada como parâmetro e esse método pode receber QUALQUER lista, um objeto será inserido
           na lista normalmente, mesmo que não seja do mesmo tipo, pois uma lista pode receber objetos.

           No exemplo abaixo, vamos adicionar um Fritante dentro de uma lista de Strings. Isso será possível pois o método
           que estamos utilizando, pede uma lista e uma lista de Strings é uma lista, logo, ela será aceita no parâmetro e como
           não temos um generics na definição do método, o objeto Fritante será inserido. */

        add(listaComGenerics, fritante); // 0 erro ou exceção.

        /* Agora, o loop abaixo irá gerar ClassCastException, pois dentro da lista existe um objeto que não é do tipo String e
           ele foi adicionado à lista quando não havia uma sintaxe diammond impedindo que ele seja incluido em tempo de compilação.

            for (String item : listaComGenerics) {
                System.out.printf("%s, ", item);
            }
         */

        /* Quando percorremos a lista por index ou utilizando um Object como rerefência, podemos percorrê-la, sendo
           necessário efetuar o cast para que possamos imprimir seus valores. */
        System.out.print("Percorrendo lista com genérics com objeto como referência: ");
        for (Object o : listaComGenerics) {
            if(o instanceof Fritante) {
                System.out.printf("Fritante %s: ", ((Fritante) o).getNome());
            } else {
                System.out.printf("%s, ", o);
            }
        }
        System.out.println("\n------------------------------");

        /* O exemplo acima serviu para exemplificar o conceito de type erasure, de forma que é possível compreender que
           apesar de a lista ser do tipo String, foi possível adicionar outro objeto. Isso aconteceu por que o método que
           adicionou o objeto na lista não considerou o tipo da lista em tempo de compilação. */

        System.out.print("Percorrendo lista com genérics por index: ");
        for (int i = 0; i < listaComGenerics.size(); i++) {
            System.out.print(listaComGenerics.get(i) + ", ");
        }
        System.out.println("\n------------------------------");
    }

    public static void add(List lista, Fritante fritante){
        lista.add(fritante);
    }
}
