package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.ArrayList;
import java.util.List;

/* Devido às mudanças que podem acontecer em um sistema, muitas das vezes é necessário alterar ou criar novas funcionalidades.
   Por isso, a parametrização de comportamentos pode deixar o sistema dinâmico. Vamos observar alguns exemplos abaixo.

   Com base nos vários exemplos utilizados podemos perceber que a parametrização de sistemas permite que seja mais dinâmico.
   Sendo assim, podemos utilizar a programação funcional para fazer isso. */
public class A193_ParametrizandoComportamentos {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.GenerateCarList();

        List<Car> greenCars = filterByGreenColor(cars);
        System.out.println("Green cars: " + greenCars);
        System.out.println("------------------------");

        List<Car> redCars = filterByRedColor(cars);
        System.out.println("Red cars: " + redCars);
        System.out.println("------------------------");

        List<Car> yellowCars = filterByColor(cars, "yellow");
        System.out.println(yellowCars);
        System.out.println("------------------------");

        List<Car> greenCarsUntil2020 = filterByColorAndYear(cars, "green", 2020);
        System.out.println("Green cars until 2020: " + greenCarsUntil2020);
    }

    // Imaginando que o cliente pediu um filtro de carros verdes, podemos obter uma lista com todos os carros dessa cor.
    public static List<Car> filterByGreenColor(List<Car> cars) {
        List<Car> retrievedCars = new ArrayList<>();
        for(Car car : cars) {
            if(car.getColor().equalsIgnoreCase("green"))
                retrievedCars.add(car);
        }
        return retrievedCars;
    }

    // Imagine que o cliente agora quer filtrar por carros vermelhos, um novo método pode ser criado para trazer os carros dessa cor.
    public static List<Car> filterByRedColor(List<Car> cars) {
        List<Car> retrievedCars = new ArrayList<>();
        for(Car car : cars) {
            if(car.getColor().equalsIgnoreCase("red"))
                retrievedCars.add(car);
        }
        return retrievedCars;
    }

    /* Na medida em que o cliente encontra possibilidades para adicionar recursos, criar vários métodos pode não ser muito funcional.
       Os métodos criados acima funcionam, mas eles poderiam ser funcionais, por exemplo, recebendo parâmetros. Dessa forma,
       ao invés de criar vários método distintos por cor, podemos criar um único metodo que recebe a cor como argumento. */
    public static List<Car> filterByColor(List<Car> cars, String color) {
        List<Car> retrievedCars = new ArrayList<>();
        for(Car car : cars) {
            if(car.getColor().equalsIgnoreCase(color))
                retrievedCars.add(car);
        }
        return retrievedCars;
    }

    // E se agora o cliente quiser filtrar por cor e por ano? Adicionaríamos mais um método, que adiciona o parâmetro ano.
    public static List<Car> filterByColorAndYear(List<Car> cars, String color, int year) {
        List<Car> retrievedCars = new ArrayList<>();
        for(Car car : cars) {
            if(car.getColor().equalsIgnoreCase(color) && car.getYear() <= year)
                retrievedCars.add(car);
        }
        return retrievedCars;
    }
}
