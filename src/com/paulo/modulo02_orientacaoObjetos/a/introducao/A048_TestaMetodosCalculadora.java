package com.paulo.modulo02_orientacaoObjetos.a.introducao;

import com.paulo.modulo02_orientacaoObjetos.a.introducao.domain.Calculadora;

public class A048_TestaMetodosCalculadora {
    public static void main(String[] args) {
        double soma = Calculadora.somar(10, 20);
        double subtracao = Calculadora.subtrair(15.33, 8.29);
        double multiplicacao = Calculadora.multiplicar(10, 20);
        double divisaoPorZero = Calculadora.dividir(10, 0);
        double divisao = Calculadora.dividir(25,5);

        System.out.printf("Soma: %.0f\n", soma);
        System.out.printf("Subtração: %.2f\n", subtracao);
        System.out.printf("Multiplicação: %.0f\n", multiplicacao);
        System.out.printf("Divisão:  %.2f\n", divisao);
        System.out.printf("Divisão por zero: %.2f\n", divisaoPorZero);
        System.out.println("---------------------------------------");

        /* A cláusula RETURN também pode ser utilizada em métodos do tipo VOID. Nesse caso, o return é utilizado para
           parar a execução do método. Por exemplo, no método abaixo, se o valor dividendo == 0, sai do método. */
        Calculadora.ImprimeDivisao(10, 0);
    }
}
