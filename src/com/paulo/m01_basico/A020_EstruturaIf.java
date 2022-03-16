package com.paulo.m01_basico;

import java.util.Scanner;

public class A020_EstruturaIf {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("Informe sua idade: ");
        int idade = in.nextInt();

        System.out.print("Quanto você tem? ");
        double valor = in.nextDouble();

        System.out.printf("Idade informada: %d - Valor informado: %.2f\n", idade, valor);

        // Testa IF primeiro caso com operadores relacional e lógico
        if(idade >= 18 || valor >= 500){
            System.out.println("Você pode entrar..");
        }else {
            System.out.println("Você não poderá entrar.");
        }
        System.out.println("-------------------------------------------------------");

        System.out.print("Informe sua idade: ");
        idade = in.nextInt();

        System.out.print("Quanto você tem? ");
        valor = in.nextDouble();

        System.out.printf("Idade informada: %d - Valor informado: %.2f\n", idade, valor);

        // Testa IF segundo caso com ELSE IF
        if(idade >= 18) {
            System.out.println("Você poderá entrar.");
        }else if(valor >= 500) {
            System.out.println("Seja bem vindo.");
        }else {
            System.out.println("Você é menor de idade e não poderá entrar.");
        }
        in.nextLine();
        System.out.println("-------------------------------------------------------");

        // Testando IF's aninhados
        System.out.println("Como está o clima (1 - SOL | 2 - FRIO | 3 - NORMAL) ? ");
        int clima = in.nextInt();

        if(clima == 1) {
            System.out.println("Clima quente: Sem camisa.");
        } else if(clima == 2){
            System.out.println("Clima frio: Camisa de frio.");
        }else if(clima == 3) {
            System.out.println("Clima normal: Camiseta.");
        }else {
            System.out.println("Valor inválido para o clima.");
        }
    }
}
