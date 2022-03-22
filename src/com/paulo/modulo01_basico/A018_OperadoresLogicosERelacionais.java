package com.paulo.modulo01_basico;

public class A018_OperadoresLogicosERelacionais {
    public static void main(String[] args) {
        // Operadores relacionais < > >= <= != !
        double valorEmCC = 3000;
        double valorEmCP = 2000;
        double valorPS5 = 7000;
        boolean credito = true;

        boolean valorEmCCEhMaiorQueValorEmCp = valorEmCC > valorEmCP;
        System.out.println("CC > CP ? " + valorEmCCEhMaiorQueValorEmCp);

        boolean valorEmCCEhMenorQueValorEmCp = valorEmCC < valorEmCP;
        System.out.println("CC < CP ? " + valorEmCCEhMenorQueValorEmCp);

        // Operadores lógicos && e || ou
        boolean temDinheiro = valorEmCC > valorPS5 || valorEmCP > valorPS5 || (valorEmCC + valorEmCP > valorPS5);
        System.out.println("Tem dinheiro pra comprar PS5? " + temDinheiro);

        boolean temDinheiroOuCredito = valorEmCC > valorPS5 || valorEmCP > valorPS5 || valorEmCC + valorEmCP > valorPS5
                                                            || (valorEmCP + valorEmCC < valorPS5 && credito);
        System.out.println("Tem dinheiro ou crédito? " + temDinheiroOuCredito);
    }
}
