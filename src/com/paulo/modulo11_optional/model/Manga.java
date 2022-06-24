package com.paulo.modulo11_optional.model;

import java.util.Objects;

public class Manga {
    private Long id;
    private String title;
    private Integer episodes;

    public Manga() {}

    public Manga(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Manga(Long id, String title, Integer episodes) {
        this(id, title);
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manga manga = (Manga) o;
        return Objects.equals(title, manga.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }
}
