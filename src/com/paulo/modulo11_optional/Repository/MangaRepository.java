package com.paulo.modulo11_optional.Repository;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo11_optional.model.Manga;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static final List<Manga> mangas = ListGenerator.generateMangasList();

    public static Optional<Manga> findById(Long id) {
        return find(m -> m.getId().equals(id));
    }

    public static Optional<Manga> findByTitle(String title) {
        return find(m -> m.getTitle().equalsIgnoreCase(title));
    }

    public static Optional<Manga> find(Predicate<Manga> predicate) {
        Manga founded = null;
        for (Manga manga : mangas) {
            if(predicate.test(manga)) {
                founded = manga;
                break;
            }
        }
        return Optional.ofNullable(founded);
    }
}
