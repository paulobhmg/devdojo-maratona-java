package com.paulo.modulo12_streams.domain;

public enum LightNovelCategoryEnum {
    ROMANCE(1L, "Romance"),
    DRAMA(2L, "Drama"),
    TERROR(3L, "Terror"),
    ACTION(4L, "Action");

    private final long id;
    private final String type;

    private LightNovelCategoryEnum(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
