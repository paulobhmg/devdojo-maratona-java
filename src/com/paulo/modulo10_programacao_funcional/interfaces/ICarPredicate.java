package com.paulo.modulo10_programacao_funcional.interfaces;

import com.paulo.modulo10_programacao_funcional.domain.Car;

@FunctionalInterface
public interface ICarPredicate {
    boolean test(Car car);

    /* Quando utilizamos a sintaxe Lambda, temos a seguinte estrutura:
    (Parâmetro) -> { return <expressão booleana>; }

    (Car car) -> car.getColor().equalsIgnoreCase("Green");

    car -> car.getColo().equalsIgnoreCase("green");

    Neste caso, precisamos passar uma variável como parâmetro e essa variável será testada pelo método test(), do Predicate. */
}
