package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo12_streams.domain.LightNovel;

import java.util.Comparator;
import java.util.List;

public class A208_UtilitariesStreamMethods {
    public static void main(String[] args) {
        List<LightNovel> lightNovels = ListGenerator.generateLightNovelsList();

        // Verifica se TODOS os itens do stream atendem a condiçao
        System.out.println("Is all items > 10 ? " + lightNovels.stream().allMatch(e -> e.getPrice() > 10));
        System.out.println("Is all items > 0  ? " + lightNovels.stream().allMatch(e -> e.getPrice() > 0));

        // Verifica se PELO MENOS UM Item do stream atende a condiçao
        System.out.println("There is any item > 10 ? " + lightNovels.stream().anyMatch(e -> e.getPrice() > 10));
        System.out.println("There is any item < 0  ? " + lightNovels.stream().anyMatch(e -> e.getPrice() < 0));

        // Verifica se NENHUM item do stream atende a condiçao. Se existir ao menos um item que atende a condiçao, retorna false.
        System.out.println("Not exists items > 10 ? " + lightNovels.stream().noneMatch(e -> e.getPrice() > 10));
        System.out.println("Not exists items > 0 ? " + lightNovels.stream().noneMatch(e -> e.getPrice() > 0));
        System.out.println("Not exists items < 0 ? " + lightNovels.stream().noneMatch(e -> e.getPrice() < 0));
        System.out.println("------------------------------------");

        /* Os métodos findAny e findFirst retornam Optional<T>, pois pode ser que não retorne nada.
           findAny retorna o primeiro objeto encontrado. Utilizamos o findAny quando não nos importamos com qual objeto
           será retornado da lista, ou seja, pode ser qualquer item da lista, o primeiro que encontrar. */
        lightNovels.stream()
                .filter(l -> l.getPrice() < 3)
                .findAny()
                .ifPresent(System.out::println);

        /* Já o findFirst retornará o primeiro objeto encontrado. Neste caso, é importante entender que o primeiro objeto
           retornado será de acordo com a a posição dos itens no stream. Sendo assim, dependendo de qual objeto queremos
           retornar, é importante primeiro ordenar o Stream. Por exemplo, aqui estamos querendo o primeiro objeto com o preço
           menor do que 3.00, porém vai ser retornado o primeiro iten dessa lista, que está ordenada por ordem alfabética, esse
           não necessariamente será o item de menor preço */
        lightNovels.stream()
                .filter(l -> l.getPrice() < 3)
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .findFirst()
                .ifPresent(System.out::println);

        /* Neste caso, o findFirst retornará realmente o item de menor valor, pois agora o stream foi ordenado por preço
           e o item de menor preço será o primeiro da lista filtrada. Aqui, podemos ainda utilizar a sintaxe min(), que
           vai retornar o menor valor da lista com base no comparator. reduzindo o código e removendo o sorted e o findFirst() */
        lightNovels.stream()
                .filter(l -> l.getPrice() < 3).min(Comparator.comparingDouble(LightNovel::getPrice))
                //.sorted(Comparator.comparingDouble(LightNovel::getPrice))
                //.findFirst()
                .ifPresent(System.out::println);
    }
}
