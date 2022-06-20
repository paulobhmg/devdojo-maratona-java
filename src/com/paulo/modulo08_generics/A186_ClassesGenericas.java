package com.paulo.modulo08_generics;

import com.paulo.modulo08_generics.domain.Barco;
import com.paulo.modulo08_generics.domain.Carro;
import com.paulo.modulo08_generics.services.Aluguel;
import com.paulo.modulo08_generics.services.AluguelDeBarco;
import com.paulo.modulo08_generics.services.AluguelDeCarro;

/* A utilização de Generics no fornece a economia e reutilização de código. Neste exemplo, temos uma lógica de aluguel
   de carros e barcos. Estamos utilizando duas classes de serviço, que fazem exatamente a mesma coisa, mudando apenas
   o tipo de objeto. Dessa forma, poderíamos ter apenas uma classe de serviço, especificada com Generics, que irá trabalhar
   com o tipo de objeto de acordo com o que foi especificado.  */
public class A186_ClassesGenericas {
    public static void main(String[] args) {
        AluguelDeCarro aluguelDeCarro = new AluguelDeCarro();
        AluguelDeBarco aluguelDeBarco = new AluguelDeBarco();

        System.out.println("TESTANDO ALUGUEL DE BARCOS: ");

        aluguelDeBarco.listarBarcosDisponiveis();
        Barco barco = aluguelDeBarco.alugarBarco();
        System.out.println("Alugando barco: " + barco.getModelo());
        aluguelDeBarco.listarBarcosDisponiveis();

        aluguelDeBarco.devolverBarco(barco);
        aluguelDeBarco.listarBarcosDisponiveis();

        System.out.println("TESTANDO ALUGUEL DE CARROS: ");

        aluguelDeCarro.listarCarrosDisponiveis();
        Carro carro = aluguelDeCarro.alugarCarro();
        System.out.println("Alugando carro: " + carro.getModelo());
        aluguelDeCarro.listarCarrosDisponiveis();

        aluguelDeCarro.devolverCarro(carro);
        aluguelDeCarro.listarCarrosDisponiveis();

        System.out.println("EXEMPLO COM GENERICS: ");

        Aluguel<Carro> carrosDisponiveis = new Aluguel<>(new Carro("T-Cross"), new Carro("Novo Polo"));
        Aluguel<Barco> barcosDisponiveis = new Aluguel<>(new Barco("Canoa"), new Barco("Iate"));

        carrosDisponiveis.listarVeiculosDisponiveis();
        Carro carro1 = carrosDisponiveis.alugarVeiculo();
        System.out.println("Alugando carro: " + carro1.getModelo());
        carrosDisponiveis.listarVeiculosDisponiveis();
        carrosDisponiveis.devolver(carro1);
        carrosDisponiveis.listarVeiculosDisponiveis();
        System.out.println("---------------------------");

        barcosDisponiveis.listarVeiculosDisponiveis();
        Barco barco1 = barcosDisponiveis.alugarVeiculo();
        System.out.println("Alugando carro: " + barco1.getModelo());
        barcosDisponiveis.listarVeiculosDisponiveis();
        barcosDisponiveis.devolver(barco1);
        barcosDisponiveis.listarVeiculosDisponiveis();
        System.out.println("---------------------------");
    }
}
