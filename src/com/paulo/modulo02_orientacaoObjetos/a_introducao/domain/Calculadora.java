package com.paulo.modulo02_orientacaoObjetos.a_introducao.domain;

public abstract class Calculadora {
    public static double dividir(double divisor, double dividendo){
        if(dividendo == 0){
            return 0;
        }
        return divisor / dividendo;
    }

    public static double multiplicar(double numero1, double numero2){
        return numero1 * numero2;
    }

    public static double somar(double numero1, double numero2){
        return numero1 + numero2;
    }

    public static double subtrair(double numero1, double numero2){
        return numero1 - numero2;
    }

    public static void ImprimeDivisao(double divisor, double dividendo){
        if(dividendo == 0){
            System.out.println("Não é permitido divisão por zero.");
            return;
        }
        System.out.println(divisor / dividendo);
    }
}
