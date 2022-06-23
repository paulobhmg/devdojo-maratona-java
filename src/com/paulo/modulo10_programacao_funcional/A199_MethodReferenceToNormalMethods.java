package com.paulo.modulo10_programacao_funcional;

import com.paulo.modulo10_programacao_funcional.comparators.CarComparators;
import com.paulo.modulo10_programacao_funcional.domain.Car;
import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

/* Podemos também utilizar MethodReferences a partir de instâncias de objetos ou a partir da própria classe, porém, nesses
   casos, o método não poderá ser static, observando que métodos estáticos não pertencem ao objeto, mas sim á classe.

   Neste caso, quando utilizamos a classe para referenciar um método, a sintaxe é exatamente a mesma utilizada para
   referenciar métodos estáticos. */
public class A199_MethodReferenceToNormalMethods {
    public static void main(String[] args) {
        List<Car> cars = ListGenerator.GenerateCarList();
        CarComparators comparators = new CarComparators();

        // Aqui estamos utilizando um ReferenceMethod a partir da instância de um objeto.
        cars.sort(comparators::compareByYearNonStatic);
        System.out.println("Cars by years non static: " + cars);
        System.out.println("------------------------");

        List<String> names = new ArrayList<>(List.of("Marilene", "Tiago", "Renato", "Paulo", "Augusto"));

        // Aqui estamos utilizando um ReferenceMethod a partir da classe de um objeto (não é necessário instanciar).
        names.sort(String::compareToIgnoreCase);
        System.out.println("Names by alphabet order non static: " + names);
        System.out.println("------------------------");

        // Utilizar lambdas e programação funcional nos permite criar objetos a partir de funções.
        Function<String, Integer> convertToNumberFullLambda = t -> Integer.parseInt(t);
        Function<String, Integer> convertToNumberReferencMethod = Integer::parseInt;

        Integer numberOfReferenceMethod = convertToNumberReferencMethod.apply("10");
        Integer numberOfFullLambda = convertToNumberFullLambda.apply("20");

        System.out.println("String parsed to number by reference method: " + numberOfReferenceMethod);
        System.out.println("String parsed to number by full lambda: " + numberOfFullLambda);
        System.out.println("-------------------------");

        /* Como poderíamos criar verificar se um iten está dentro de uma lista? Poderíamos utilizar o Predicate, porém
           Predicate só aceita um parâmetro, para isso, podemos então utilizar um BiPredicate */
        BiPredicate<List<String>, String> checkName = (list, name) -> list.contains(name);
        BiPredicate<List<String>, String> checkNameByClass = List::contains;

        boolean containsNameOnList = checkName.test(names, "paulo");
        boolean containsNameOnListNameByClass = checkName.test(names, "paulo");

        System.out.println(containsNameOnList);
        System.out.println(containsNameOnListNameByClass);
    }
}
