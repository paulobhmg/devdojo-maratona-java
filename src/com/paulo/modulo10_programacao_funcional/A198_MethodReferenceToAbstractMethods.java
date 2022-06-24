package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.comparators.CarComparators;
import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.List;

/* MethodReference é uma sintaxe que melhora ainda mais a legibilidade do código quando estamos utilizando lambdas,
   porém só são permitidas quando dentro da expressão lambda temos apenas uma chamada à métodos. */
public class A198_MethodReferenceToAbstractMethods {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.generateCarsList();
        System.out.println("Car list unorganized: \n" + cars);
        System.out.println("--------------------");

        cars.sort((c1, c2) -> Integer.compare(c1.getYear(), c2.getYear()));
        System.out.println("Comparing by year with full lambda: \n" + cars);
        System.out.println("--------------------");

        /* Quando utilizamos MethodReferences, ampliamos as possibilidades funcionais de um código. No exemplo acima,
           a lista está sendo ordenada utilizando um lambda completo, através do método compare() do Comparator, porém,
           quando utilizamos MethodReferences, podemos utilizar uma classe que NÃO é um comparator para isso.
           Isso acontece por que uma lambda leva em consideração apenas duas coisas: o target type e a function description:
           Target type é basicamente o contexto de onde a lambda está atuando, neste caso, como um comparator,
           Function description é o corpo da expressão. Sendo assim, podemos ter uma classe qualquer que tenha um método
           similar ao método compare(), ou seja, receba dois parâmetros e retorne um int, que funcionará normalmente,
           mesmo que não seja um comparator. */

        /* Note que quando utilizamos a sintaxe MethodReference, os parâmetros ficam implícitos, ou seja, não são necessários.
           O Java sabe quais são os parâmetros que o método e usa esses parâmetros automaticamente no método sort(). */
        cars.sort((c1, c2) -> CarComparators.compareByColor(c1, c2)); // Com lambda Completa
        cars.sort(CarComparators::compareByColor);
        System.out.println("Comparing by color with Abstract Method reference:\n" + cars);
        System.out.println("---------------------");

        cars.sort(CarComparators::compareByModel);
        System.out.println("Comparing by model with abstract method reference: \n" + cars);
        System.out.println("---------------------");

        cars.sort(CarComparators::compareByYear);
        System.out.println("Comparing by year with abstract method reference: \n" + cars);
        System.out.println("---------------------");

        /* Podemos perceber que os métodos funcionaram perfeitamente, que o objeto passado como parâmetro não seja um comparator.
           Isso acontece pois devido ao contexto e a assinatura do método, o Java sabe o que tem que ser feito. */
    }
}
