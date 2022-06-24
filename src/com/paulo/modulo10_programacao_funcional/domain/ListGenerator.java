package com.paulo.modulo10_programacao_funcional.domain;

import com.paulo.modulo11_optional.model.Manga;
import com.paulo.modulo12_streams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;

public abstract class ListGenerator {
    public static List<Car> generateCarsList() {
        return
                new ArrayList<>(List.of(
                        new Car("T-Cross", "Green", 2023),
                        new Car("Novo polo", "Yellow", 2022),
                        new Car("Golf G8", "Grey", 2023),
                        new Car("New Beatle", "Black", 2018),
                        new Car("Kombi velha", "White", 2007),
                        new Car("Novo polo", "Green", 2020),
                        new Car("T-Cross", "Grey", 2019),
                        new Car("Gol", "red", 2018),
                        new Car("Fiat Uno", "Black", 2013),
                        new Car("Novo Palio", "white", 2016),
                        new Car("Sandero", "Yellow", 2010),
                        new Car("Voyage", "red", 2015)
                ));
    }

    public static List<String> generateNamesList() {
        return
                new ArrayList<>(List.of("Marilene", "Tiago", "Renato", "Paulo", "Augusto", "Ronaldo", "Mateus", "Stella"));
    }

    public static List<Manga> generateMangasList() {
        return new ArrayList<>(List.of(
                new Manga(1L, "Bleach", 1599),
                new Manga(2L, "Shingeki no kyogin", 300),
                new Manga(3L, "Naruto", 5000),
                new Manga(4L, "Dragon ball", 3299)
        ));
    }

    public static List<LightNovel> generateLightNovelsList() {
        return new ArrayList<>(List.of(
           new LightNovel(1L, "Naruto", 2.88),
           new LightNovel(2L, "Shingeki no kyogin", 5.24),
           new LightNovel(3L, "Bleach", 9.20),
           new LightNovel(4L, "Bersek", 1.38),
           new LightNovel(5L,"Dragon ball", 10.23),
           new LightNovel(6L, "Dota2 - Blood of dragon", 2.89),
           new LightNovel(7L, "One Piece", 1.25),
           new LightNovel(8L, "One Piece", 1.25)
        ));
    }
}
