package com.paulo.modulo01_basico;

public class A015_OperadoresAritmeticos {
    public static void main(String[] args) {
        // Operadores aritméticos + - * / % (binário) | ++ -- (unário)
        int somaInteiro = 10 + 13;
        int subtracaoInteiro = 13 - 10;
        // int multiplicacaoInteiro = 13 * 10.5; Esse código não funciona, pois um INT não pode armazenar um DOUBLE.
        double multiplicacao = 13 * 10.5;
        int divisaoInteiro = 10 / 3;  // Divisão entre valores inteiros retorna valor inteiro, ou seja, ignora casas decimais.
        double divisaoDouble = (double) 10 / 3; // Para a divisão retornar um double, é necessário haver pelo menos um double.
        int resto = 10 % 3;

        //Testando operadores unários (incremento e decremento)
        System.out.println("---------- Operadores aritméticos --------");
        System.out.printf("Soma: %d\n", somaInteiro);
        System.out.printf("Subtração: %d\n", subtracaoInteiro);
        System.out.printf("multiplicação: %d, %.2f\n", (int) multiplicacao, multiplicacao); // Parâmetro %d nao é válido para double
        System.out.printf("divisao inteira: %d\n", divisaoInteiro);
        System.out.printf("divisao double: %.2f\n", divisaoDouble);
        System.out.printf("resto da divisão inteira: %d\n", resto);

        System.out.println("\n------ Incremento e decremento ------ ");
        System.out.printf("Soma pré incremento: %d \n", ++somaInteiro);  // Incrementa, depois soma o valor
        System.out.printf("Soma pos incremento: %d \n", somaInteiro ++); // Usa o valor, depois incrementa
        System.out.printf("Valor atual soma: %d \n\n", somaInteiro);

        System.out.printf("Soma pré decremento: %d \n", --somaInteiro); // Decrementa, depois usa o valor.
        System.out.printf("Soma pós decremento: %d \n", somaInteiro--); // Usa o valor, depois decrementa.
        System.out.printf("Valor atual da soma: %d \n\n", somaInteiro);

        somaInteiro += 10;
        System.out.printf("Soma = soma + 10: %d \n", somaInteiro);

        somaInteiro -= 10;
        System.out.printf("Soma = soma - 10: %d \n", somaInteiro);

        somaInteiro *= 10;
        System.out.printf("Soma = soma * 10: %d \n", somaInteiro);

        somaInteiro /= 10;
        System.out.printf("Soma = soma / 10: %d \n", somaInteiro);
    }
}
