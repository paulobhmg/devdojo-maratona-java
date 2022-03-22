package com.paulo.modulo01_basico;

public class A030_BreakOuContinueNoLacoDeRepeticao {
    public static void main(String[] args) {
        double parcela = 0;
        double valorDoCarro = 28000;

        // Interrompendo laço de repetição com BREAK
        for(int i = 1; i <= valorDoCarro; i++) {
            parcela = valorDoCarro / i;
            if(parcela < 1000) {
                break;
            }
            System.out.println(i + " x R$ " + parcela);
        }
        System.out.println("------------------------");

        // Alterando a lógica do cálculo com o CONTINUE
        for(int i = (int) valorDoCarro; i >= 1; i--){
            parcela = valorDoCarro / i;
            if(parcela < 1000){
                continue;
            }
            System.out.println(i + " x R$ " + parcela);
        }
    }
}
