package com.paulo.modulo08_generics.services;

import com.paulo.modulo08_generics.domain.Barco;

import java.util.ArrayList;
import java.util.List;

public class AluguelDeBarco {
    private List<Barco> barcosDisponiveis = new ArrayList<>();

    public AluguelDeBarco (){
        this.barcosDisponiveis = new ArrayList<>(List.of(new Barco("Canoa"), new Barco("Iate")));
    }

    public void listarBarcosDisponiveis() {
        System.out.print("Barcos disponíveis: ");
        for (Barco barco : barcosDisponiveis) {
            System.out.printf("%s, ", barco.getModelo());
        }
        System.out.println("\n---------------");
    }

    public Barco alugarBarco() {
        Barco barco = barcosDisponiveis.remove(0);
        return barco;
    }

    public void devolverBarco(Barco barco) {
        System.out.println("Devolvendo Barco " + barco.getModelo());
        barcosDisponiveis.add(barco);
    }
}
