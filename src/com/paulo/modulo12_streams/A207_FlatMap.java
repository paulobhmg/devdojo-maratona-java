package com.paulo.modulo12_streams;

import com.paulo.modulo10_programacao_funcional.domain.ListGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/* Fixando o conceito de flatMap */
public class A207_FlatMap {
    public static void main(String[] args) {
        // Da forma tradicional, caso quiséssemos tranformar cada palavra em uma Lista de Strings em um array, faríamos assim
        List<String> names = ListGenerator.generateNamesList();
        for (String name : names ){
            System.out.print(Arrays.toString(name.split("")) + " - ");
        }
        System.out.println("\n--------------------");

        // Utilizando o flatMap, faríamos assim
        List<String[]> collect = names.stream().map(s -> s.split("")).collect(Collectors.toList());
        collect.forEach(e -> System.out.print(Arrays.toString(e) + " - "));
        System.out.println("\n--------------------");

        // Criando uma lista de strings a partir dos arrays
        List<String> collect1 = names.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
        System.out.println(collect1);
    }
}
