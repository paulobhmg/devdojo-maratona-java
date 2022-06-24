package com.paulo.modulo11_optional;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.List;
import java.util.Optional;

/* A classe Optional foi introduzida no Java 8 e tem como objetivo melhorar a visibilidade do código e minimizar
   exceções do tipo NullPointerException, de forma funcional.   */
public class A201_Optional {
    public static void main(String[] args) {
        List<String> names = ListGenerator.generateNamesList();

        try {
            /* Quando tentamos acessar um método ou atributo de um objeto NULL, obtemos a exceção NullPointerException, pois
               um objeto nulo não tem métodos ou atributos para serem acessados. Sendo assim, como o método findName() está
               retornando NULL, ao acessar o método toUpperCase() obtemos a exceção NullPointerException */
            String pedro = findName(names, "Pedro");
            System.out.println(pedro.toUpperCase());
        } catch (RuntimeException e) {
            System.out.println("The method used to get a Optional can return a null value an cannot be treated by" +
                    " the Optional check value");
        }

        try {
            /* Temos algumas formas de obter um Optional. A forma abaixo não elimina a possibilidade de gerar exceção,
               pois o objeto dentro do optional pode estar nulo. Dessa forma, mesmo utilizando o método orElse() do Optional,
               não conseguimos tratar a nullabilidade do valor. */
            Optional<String> getOptionalByFirstMethod = Optional.of(findName(names, "Pedro"));
            String nameRetriviedByGetFirstMethodOfOption = getOptionalByFirstMethod.orElse("Vazio");
            System.out.println(nameRetriviedByGetFirstMethodOfOption.toUpperCase());
        } catch (RuntimeException e) {
            System.out.println("The method used to get a Optional can return a null value an cannot be treated by" +
                    " the Optional check value");
        }

        /* Esta é a melhor forma para se obter um objeto do tipo Optional. Neste caso, estamos informando que um Optional
           pode estar nulo. Sendo assim, é necessário verificar se o objeto isPresent() dentro do Optional, pois caso
           não tenha objeto presente, será lançada exceção NoSuchElementException. Mas utilizando essa forma, podemos
           tratar uma segunda alternativa para caso nao tenha valor presente no Optional. */
        Optional<String> getOptionalBySecondMethod = Optional.ofNullable(findName(names, "Pedro"));
        // String nameRetrievedBySecondOptionalMethod = getOptionalBySecondMethod.get(); -- Sem verificar gera exceçao
        String nameRetrievedBySecondOptionalMethod = getOptionalBySecondMethod.isPresent() ? getOptionalBySecondMethod.get().toUpperCase() : "Vazio";
        String nameRetrievedBySecondOptionalMethod2 = getOptionalBySecondMethod.orElse("Vazio");
        System.out.println(nameRetrievedBySecondOptionalMethod);
        System.out.println(nameRetrievedBySecondOptionalMethod2);

        // Caso queiramos obter um Optional vazio, utilizamos a sintaxe empty()
        Optional<String> emptyOptional = Optional.empty();
        String empty = emptyOptional.isEmpty() ? "Empty" : emptyOptional.get();
        System.out.println(empty);

        Optional<String> option = findNameOptional(names, "Paulo");
        System.out.println(option.orElse("está vazio."));
    }

    public static String findName(List<String> list, String name) {
        int index = list.indexOf(name);
        return index != -1 ? list.get(index) : null;
    }

    /*  Um metodo que retorna um Optional de forma correta seria assim, pois da forma como esta o corpo desse metodo,
        ou o metodo ira retornar um Optional contendo uma String nome, ou retornara um Optional vazio. Dessa forma,
        nunca sera lançada um NullPointerException para este metodo. Mas o valor devera ser tratado. */
    public static Optional<String> findNameOptional(List<String> list, String name) {
        int index = list.indexOf(name);
        return index != -1 ? Optional.of(list.get(index)) : Optional.empty();
    }
}
