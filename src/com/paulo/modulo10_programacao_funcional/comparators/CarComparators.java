package com.paulo.modulo10_programacao_funcional.comparators;

import com.paulo.modulo10_programacao_funcional.domain.Car;

/* Ao criar uma classe assim, podemos definir inúmeras formas de comparação para um objeto específico ou genérico,
   possibilitando inúmeras implementações e possibilidades de uso no sistema. */
public class CarComparators {
    public static int compareByYear(Car c1, Car c2) {
        return Integer.compare(c1.getYear(), c2.getYear());
    }

    public static int compareByModel(Car c1, Car c2) {
        return c1.getModel().compareToIgnoreCase(c2.getModel());
    }

    public static int compareByColor(Car c1, Car c2) {
        return c1.getColor().compareToIgnoreCase(c2.getColor());
    }
}
