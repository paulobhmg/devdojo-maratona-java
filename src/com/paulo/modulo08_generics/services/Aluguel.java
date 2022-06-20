package com.paulo.modulo08_generics.services;

import com.paulo.modulo08_generics.domain.Barco;
import com.paulo.modulo08_generics.domain.Carro;

import java.util.ArrayList;
import java.util.List;

public class Aluguel <T> {
    private final List<T> itensDisponiveis;

    public Aluguel (T... objects) {
        itensDisponiveis = new ArrayList<>(List.of(objects));
    }

    public void listarVeiculosDisponiveis() {
        String tipo =  itensDisponiveis.get(0) instanceof Carro ? "Carros" : "Barcos";
        System.out.print(tipo + " disponíveis: ");
        for (T t : itensDisponiveis) {
            System.out.printf("%s, ", t);
        }
        System.out.println();
    }

    public T alugarVeiculo() {
        return itensDisponiveis.remove(0);
    }

    public void devolver(T t) {
        System.out.println("Devolvendo veículo " + t);
        itensDisponiveis.add(t);
    }
}
