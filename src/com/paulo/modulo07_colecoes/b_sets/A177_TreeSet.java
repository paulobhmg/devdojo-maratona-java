package com.paulo.modulo07_colecoes.b_sets;

import com.paulo.modulo07_colecoes.domain.Anime;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

class SortAnimeByName implements Comparator<Anime> {
    @Override
    public int compare(Anime a1, Anime a2) {
        return a1.getName().compareToIgnoreCase(a2.getName());
    }
}

public class A177_TreeSet {
    public static void main(String[] args) {
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        NavigableSet<Anime> animes = new TreeSet<>(new SortById());

        animes.addAll(List.of(shinge, dragon, bleach, bersek, naruto));

        // Ordenando um TreeMap por ordem decrescente
        for(Anime anime : animes.descendingSet()) {
            System.out.println(anime);
        }
        System.out.println("-----------------------------------------");

        /* Assim como para insersão, um TreeSet utiliza o compareTo() ou compare() para comparar objetos. Os métodos abaixo
           são executados de acordo com as seguintes regras:

           lower() -> Retorna o primeiro item da coleção que está abaixo daquele passado como parâmetro
           floor() -> Retorna o primeiro item que está abaixo ou igual ao item passado como parâmetro
           higher() -> Retorna o primeiro item da coleção que está acima daquele passado como parâmetro
           ceiling() -> Retorna o primeiro item que está acima ou igual ao item passado como parâmetro */

        Anime anime = new Anime(8L, "Boruto", 1020);
        animes.add(anime);

        System.out.println("Primeiro ID abaixo de 8: " + animes.lower(anime));
        System.out.println("Primeiro ID abaixo de 8 OU 8: " + animes.floor(anime));
        System.out.println("Primeiro ID acima de 8: " + animes.higher(anime));
        System.out.println("Primeiro ID acima de 8 OU: " + animes.ceiling(anime));
        System.out.println("------------------------------------------");

        // Retorna e remove o primeiro item da coleção
        Anime primeiroAnime = animes.pollFirst();
        Anime ultimoAnime = animes.pollLast();

        System.out.println(animes);
        System.out.println("------------------------------------------");

        // Exemplificando a insersão de valores repetidos - Neste caso, o comparator está considerando o ID como definidor de valor duplicado.
        Anime bleachRepetido = new Anime(5L, "BleachRepetido", 1020);
        animes.add(bleachRepetido);
        System.out.println("Tenta inserir bleach repetido (fail): " + animes);

        /* Neste caso o anime vai ser adicionado, pois apesar de o nome ser o mesmo, o ID é diferente e é ele quem está
           sendo considerado para ordenação do comparator. */
        Anime narutoRepetido = new Anime(7L, "Naruto", 1000);
        animes.add(narutoRepetido);
        System.out.println("Tenta inserir naruto repetido (ok) : " + animes);
        System.out.println("------------------------------------------");

        /* Fazer teste alterando a implementação do comparator para considerar o nome do anime como duplicidade.
           Como resultado, na primeira tentativa, Bleach deverá ser duplicado lista por ID, enquanto Naruto não. */
        animes = new TreeSet<>(new SortAnimeByName());
        animes.addAll(List.of(shinge, dragon, bleach, bersek, naruto));
        System.out.println("Animes by name: " + animes);

        // Tentar inserir anime repetido por ID:
        Anime bleachRepetidoOk = new Anime(5L, "BleachRepetido", 1020);
        animes.add(bleachRepetidoOk);
        System.out.println("Insere bleach repetido por ID (ok): " + animes);

        /* Como é possível perceber, agora que os animes estão sendo classificados por nome, ao inserir um anime de nome Naruto,
           que já existe na lista, esse não será inserido, comprovando que o TreeSet não considera o equals e hashcode na
           insersão de um novo item na coleção. */
        Anime narutoRepetidoFail = new Anime(26L, "naruto", 1000);
        animes.add(narutoRepetidoFail);
        System.out.println("Insere naruto repetido por nome (fail): " + animes);
    }
}
