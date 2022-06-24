package com.paulo.modulo12_streams.domain;

import java.util.Objects;

public class LightNovel {
    private Long id;
    private String title;
    private Double price;

    public LightNovel() {}

    public LightNovel(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public LightNovel(Long id, String title, Double price) {
        this(id, title);
        this.price = price;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LightNovel that = (LightNovel) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
