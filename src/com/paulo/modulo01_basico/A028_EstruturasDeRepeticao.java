package com.paulo.modulo01_basico;

public class A028_EstruturasDeRepeticao {
    public static void main(String[] args) {
        int i = 0;

        // while só é executado caso a expressão no parâmetro seja verdadeira
        while(i <= 10) {
            System.out.print(i);
            if(i < 10)
                System.out.print(", ");
            i++;
        }
        System.out.println();

        // do-while só faz a verificação após o código ser executado ao menos uma vez.
        i = 0;
        do {
            System.out.print(i);
            if(i < 10) {
                System.out.print(", ");
            }
            i++;
        } while(i <= 10);
        System.out.println();

        // Nesse exemplo, o do-while irá executar o laço, mesmo que a condição seja falsa. Só executa uma vez.
        do {
            System.out.println("laço do-while com condição falsa.");
        }while (false);

        // for irá executar o código X vezes, com base no parâmetro passado na assinatura do laço
        for(i = 0; i <= 10; i++){
            System.out.print(i);
            if(i < 10){
                System.out.print(", ");
            }
        }
        System.out.println();

        // Imprimindo apenas números pares dentro de um intervalo com for
        for(i = 0; i <= 100; i++){
            if(i % 2 == 0){
                System.out.print(i);
                if(i < 100){
                    System.out.print(", ");
                }
            }
        }
        System.out.println();
    }
}
