package com.paulo.modulo10_programacao_funcional.domain;

import java.util.Objects;

public class Car {
    private String model;
    private String color;
    private Integer year;

    public Car() {}

    public Car(String model, String color, Integer year) {
        Objects.requireNonNull(model, "Model cannot be null.");
        Objects.requireNonNull(color, "Color cannot be null.");
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" + "model='" + model + '\'' + ", color='" + color + '\'' + ", year=" + year + '}';
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || getClass() != o.getClass()) return false;
        if(this == o) return true;
        Car car = (Car) o;
        return model.equalsIgnoreCase(car.model) && color.equalsIgnoreCase(car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, color);
    }
}
