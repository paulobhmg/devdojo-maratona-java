package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo07_colecoes.domain.Anime;
import com.paulo.modulo10_programacao_funcional.interfaces.TriFunction;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/* Também podemos instanciar objetos a partir de Reference Methods. Neste caso, utilizamos a interface funcional
   Supplier, que através do método get() */
public class A200_MethodReferenceToConstructors {
    public static void main(String[] args) {
        /* Um Supplier definido dessa maneira só consegue trabalhar com um construtor sem parâmetros, pois o método
           get() do Supplier não possui parâmetros. */
        Supplier<Anime> animeSupplier = Anime::new;
        Anime anime = animeSupplier.get();

        anime.setId(1L);
        anime.setName("Shingeki no kyogin");
        anime.setEpisodes(130);
        System.out.println(anime);
        System.out.println("---------------------------");

        // Caso queira retornar um objeto que possui mais de um parâmetro, podemos utilizar o BiFunction<>
        BiFunction<Long, String, Anime> makeAnimeBySupplier = Anime::new;
        Anime bleach = makeAnimeBySupplier.apply(2L, "Bleach");
        bleach.setEpisodes(366);
        System.out.println(bleach);
        System.out.println("---------------------------");

        TriFunction<Long, String, Integer, Anime> makeAnimeBySupllier2 = Anime::new;
        Anime dota2 = makeAnimeBySupllier2.apply(3L, "Dota2, blood of dragon", 20);
        System.out.println(dota2);
        System.out.println("---------------------------");
    }
}
