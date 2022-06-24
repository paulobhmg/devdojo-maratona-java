package com.paulo.modulo12_streams;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* Utilizamos o FlatMap quando precisamos trabalhar com Streams de objetos aninhados, como por exemplo listas de listas.
   Enquanto o map por exemplo trabalha no primeiro nível, o flatMap trabalha no segundo nível dentro de uma estrutura
   aninhada. */
public class A206_FlatMap {
    public static void main(String[] args) {
        List<String> brothers = new ArrayList<>(List.of("Tiago", "Renato", "Paulo", "Augusto", "Mateus", "Stella"));
        List<String> girlFriends = new ArrayList<>(List.of("Nadille", "Hellen", "Daiane", "Luciana"));
        List<String> parenths = new ArrayList<>(List.of("Marilene", "Ronaldo"));

        List<List<String>> family = new ArrayList<>(List.of(brothers, parenths, girlFriends));

        // Percorrendo uma lista assim de forma tradicional
        for (List<String> strings : family) {
            for (String member : strings) {
                System.out.print(member + ", ");
            }
            System.out.println();
        }
        System.out.println("----------------------");

        // Percorrendo da forma correta utilizando flatMap
        family.stream()
                .flatMap(list -> list.stream())
                .forEach(name -> System.out.print(name + ", ")); // Notar que após o forEach não é possível executar outra operação
        System.out.println("\n----------------------");

        family.stream()
                .flatMap((Collection::stream))
                .forEach(m -> System.out.print(m + ", "));
        System.out.println("\n----------------------");
    }
}
