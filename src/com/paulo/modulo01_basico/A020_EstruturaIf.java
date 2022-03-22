package com.paulo.modulo01_basico;

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

        // Testando IF's aninhados - Os IF's internos só serão executados caso a condição "valor" seja satisfatória
        if(valor > 300) {
            System.out.println("Como está o clima (1 - SOL | 2 - FRIO | 3 - NORMAL) ? ");
            int clima = in.nextInt();
            if (clima == 1) {
                System.out.println("Clima quente: Sem camisa.");
            } else if (clima == 2) {
                System.out.println("Clima frio: Camisa de frio.");
            } else if (clima == 3) {
                System.out.println("Clima normal: Camiseta.");
            } else {
                System.out.println("Valor inválido para o clima.");
            }
        } else {
            System.out.printf("Com %.2f não dá para sair :(\n", valor);
        }
        in.nextLine();
        System.out.println("--------------------------------------------");

        // Variáveis locais deverão ser obrigatóriamente inicializadas anes de serem referenciadas no código
        System.out.print("Informe sua idade: ");
        idade = in.nextInt();
        String categoriaInicializada = "";
        String categoriaNaoInicializada;

        if(idade < 15) {
            categoriaNaoInicializada = categoriaInicializada = "Infantil";
        }else if(idade >= 15 && idade <= 18) {
            categoriaNaoInicializada = categoriaInicializada = "Juvenil";
        }else {
            categoriaInicializada = "Adulto";
        }
        System.out.println("Categoria: " + categoriaInicializada);

        /* O comando abaixo está incorreto, pois é possível que a aplicação não entre em nenhum dos dois blocos IF para
           que define uma categoria. Sendo assim, a variável não receberia nenhum valor. Portanto, seria uma variável
           não inicializada.

           System.out.println("Categoria: " + categoriaNaoInicializada);
         */
    }
}
