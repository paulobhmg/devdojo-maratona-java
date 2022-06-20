package com.paulo.modulo08_generics.services;

import com.paulo.modulo08_generics.domain.Carro;

import java.util.ArrayList;
import java.util.List;

public class AluguelDeCarro {
    private List<Carro> carrosDisponiveis = new ArrayList<>();

    public AluguelDeCarro (){
        this.carrosDisponiveis = new ArrayList<>(List.of(new Carro("T-Cross"), new Carro("Novo polo")));
    }

    public void listarCarrosDisponiveis() {
        System.out.print("Carros disponíveis: ");
        for (Carro carro : carrosDisponiveis) {
            System.out.printf("%s, ", carro.getModelo());
        }
        System.out.println("\n---------------");
    }

    public Carro alugarCarro() {
        Carro carro = carrosDisponiveis.remove(0);
        return carro;
    }

    public void devolverCarro(Carro carro) {
        System.out.println("Devolvendo carro " + carro.getModelo());
        carrosDisponiveis.add(carro);
    }
}
