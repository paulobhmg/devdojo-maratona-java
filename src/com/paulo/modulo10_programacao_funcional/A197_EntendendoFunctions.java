package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/* Functions também são interfaces funcionais que atuam sobre um objeto e retornam outro.
   Para fixar o conceito de lambdas temos:
   1 - Predicate: Valida condições passadas em uma expressão lambda, retornando true ou false
   2 - Consumer: Executa uma ação sobre o objeto passado como parâmetro
   3 - Function: Recebe um objeto como parâmetro ,executa alguma ação e retorna um novo objeto, de qualquer tipo. */
public class A197_EntendendoFunctions {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.generateCarsList();
        System.out.println(cars);

        List<String> listOfCarColors = makesNewObjectList(cars, car -> car.getColor());
        System.out.println(listOfCarColors);

        List<Integer> listOfCarYears = makesNewObjectList(cars, car -> car.getYear());
        System.out.println(listOfCarYears);
        System.out.println("-------------------");

        Integer carYear = makesNewObject(new Car("CB Twister", "Matt Grey", 2022), car -> car.getYear());
        System.out.println(carYear);
    }

    public static <T, R> List<R> makesNewObjectList(List<T> objects, Function<T, R> function) {
        List<R> list = new ArrayList<>();
        for (T e :objects) {
            list.add(function.apply(e));
        }
        return list;
    }

    public static <T, R> R makesNewObject(T object, Function<T, R> function){
        return function.apply(object);
    }
}
