package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.List;
import java.util.function.Consumer;

/* Assim como um Predicate, um Consumer é uma interface funcional que recebe um objeto como parâmetro, mas ao invés de
   efetuar um teste booleando, executa uma ação do tipo void sobre o objeto. */
public class A196_ConceituandoConsummer {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.generateCarsList();

        // Para cada item da lista, o consumer irá executar o método System.out.println() , passando-o como parâmetro.
        forEach(cars, car -> System.out.println(car));
    }

    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
