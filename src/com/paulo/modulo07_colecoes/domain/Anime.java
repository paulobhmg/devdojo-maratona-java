package com.paulo.modulo07_colecoes.domain;

import java.util.Objects;

public class Anime implements Comparable<Anime> {
    private Long id;
    private String name;
    private Integer episodes;

    public Anime() {
    }

    public Anime(Long id, String name, Integer episodes) {
        this.id = id;
        this.name = name;
        this.episodes = episodes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEpisodes() {
        return episodes;
    }

    public void setEpisodes(Integer episodes) {
        this.episodes = episodes;
    }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", name='" + name + '\'' + ", episodes=" + episodes + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return Objects.nonNull(name) && name.equalsIgnoreCase(((Anime) o).name);
    }

    @Override
    public int hashCode() {
        return Objects.nonNull(name) ? name.hashCode() : 0;
    }

    @Override
    public int compareTo(Anime anime){
        /* if(episodes < anime.episodes) {
            return -1;
        }else if(episodes == anime.episodes) {
            return 0;
        }else {
            return 1;
        } */

        // return Integer.compare(episodes, anime.episodes);

        // return Long.compare(id, anime.id);

        return name.compareTo(anime.name);
    }
}
