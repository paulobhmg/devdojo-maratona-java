package com.paulo.modulo10_programacao_funcional.domain;

import com.paulo.modulo11_optional.model.Manga;

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
}
