package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.Comparator;
import java.util.List;

/* Lambdas são basicamente classes anônimas que utilizam uma sintaxe simplificada, afim de deixar o código mais limpo e
   legível. Apesar de serem basicamente classes anônimas, são consideradas como funções, pois elas não têm vínculo com
   demais objetos e são utilizadas para operações específicas.

   Para utilizar lambdas é imprecindível que a interface interface utilizada como Predicate seja uma interface funcional.
   Interfaces funcionais são aquelas que possuem APENAS UM MÉTODO ABSTRATO e podem ou não acompanhar a anotação @FunctionalInterface.

   Ao utilizar a sintaxe lambda, automaticamente será chamado o ÚNICO MÉTODO ABSTRATO da classe utilizada como Predicate.
   Ver detalhes da sintaxe lambda na classe ICarPredicate. */
public class A195_ConceituandoInterfacesFuncionais {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.GenerateCarList();
        cars.sort((o1, o2) -> Integer.compare(o1.getYear(), o2.getYear()));

        System.out.println(cars);
    }
}
