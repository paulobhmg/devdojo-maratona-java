package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;
import com.paulo.modulo10_programacao_funcional.interfaces.ICarPredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/* Para diminuir a repetição de código utilizado na última classe, podemos passar a responsabilidade de testar as condições
   do filtro para uma interface Predicate. Um Predicate basicamente é uma interface que possui apenas um método test().
   Esse método será o responsável por testar as condições passadas como parâmetro, preferencialmente através de
   lambda expressions.
   Dessa forma, independente da condição exigida, o responsável por fazer o teste é o Predicate. */
public class A194_ParametrizacaoComLambdas {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.GenerateCarList();

        // Interface Predicate criada por desenvolvedor
        List<Car> greenCars = filter(cars, new ICarPredicate() {
            @Override
            public boolean test(Car car) {
                return car.getColor().equalsIgnoreCase("green");
            }
        });

        System.out.println("Green cars: " + greenCars);
        System.out.println("------------------------");

        // Utilizando a mesma interface anterior, porém utilizando lambda expressions
        List<Car> redCars = filter(cars, car -> car.getColor().equalsIgnoreCase("red"));
        System.out.println("Red cars: " + redCars);
        System.out.println("------------------------");

        // Utilizando a classe Predicate para o teste
        List<Car> greenCarsUntil2020 = filterWithPredicate(cars, car -> car.getColor().equalsIgnoreCase("green") && car.getYear() <= 2020);
        System.out.println("Green cars until 2020: " + greenCarsUntil2020);
        System.out.println("------------------------");

        // Utilizando Predicate com filtro genérico
        List<Car> yellowCarsAfter2020 = genericFilterWithPredicate(cars, car -> car.getColor().equalsIgnoreCase("yellow") && car.getYear() >= 2020);
        System.out.println("Yellow cars after 2020: " + yellowCarsAfter2020);
        System.out.println("------------------------");

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Pair numbers: " + genericFilterWithPredicate(numbers, num -> num % 2 == 0));
        System.out.println("------------------------");
    }

    public static List<Car> filter(List<Car> cars, ICarPredicate predicate) {
        List<Car> carsRetrieved = new ArrayList<>();
        for (Car car : cars) {
            if(predicate.test(car)) {
                carsRetrieved.add(car);
            }
        }
        return carsRetrieved;
    }

    public static List<Car> filterWithPredicate(List<Car> cars, Predicate<Car> predicate) {
        List<Car> filteredCars = new ArrayList<>();
        for (Car car : cars) {
            if(predicate.test(car))
                filteredCars.add(car);
        }
        return filteredCars;
    }

    // Ainda podemos criar um método genérico, que fará o filtro em qualquer lista passada como parâmetro
    public static <T> List<T> genericFilterWithPredicate(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t))
                filteredList.add(t);
        }
        return filteredList;
    }
}
