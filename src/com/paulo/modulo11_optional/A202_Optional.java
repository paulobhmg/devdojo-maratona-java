package com.paulo.modulo11_optional;

import com.paulo.modulo11_optional.Repository.MangaRepository;
import com.paulo.modulo11_optional.model.Manga;

import java.util.Optional;

public class A202_Optional {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Bleach");
        mangaByTitle.ifPresent(m -> m.setTitle("New Bleach is comming."));
        System.out.println(mangaByTitle);

        Optional<Manga> mangaByIdOrNew = MangaRepository.findById(5L);
        Manga newManga = mangaByIdOrNew.orElseGet(() -> new Manga(5L, "Dota2, dragon of bloods", 20));
        System.out.println(newManga);

        Manga mangaOrThrows = mangaByIdOrNew.orElseThrow(IllegalArgumentException::new);
        System.out.println(mangaOrThrows);
    }
}
