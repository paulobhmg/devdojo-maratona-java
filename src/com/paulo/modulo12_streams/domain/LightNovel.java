package com.paulo.modulo12_streams.domain;

import java.util.Objects;

public class LightNovel {
    private Long id;
    private String title;
    private Double price;
    private LightNovelCategoryEnum category;
    private LightNovelPromotionEnum promotion;

    public LightNovel() {}

    public LightNovel(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public LightNovel(Long id, String title, Double price) {
        this(id, title);
        this.price = price;
    }

    public LightNovel(Long id, String title, Double price, LightNovelCategoryEnum category) {
        this(id, title, price);
        this.category = category;
    }

    public LightNovel(Long id, String title, Double price, LightNovelCategoryEnum category, LightNovelPromotionEnum promotion) {
        this(id, title, price, category);
        this.promotion = promotion;
    }

    @Override
    public String toString() {
        return "LightNovel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category=" + (category != null ? category.getType() : "undefine") +
                ", promotion=" + (promotion != null ? promotion : "undefine") +
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

    public LightNovelCategoryEnum getCategory() {
        return category;
    }

    public LightNovelPromotionEnum getPromotion() {
        return promotion;
    }
}
