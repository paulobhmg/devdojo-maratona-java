/* Arrays multimdimencionais permitem adicionar níveis entre mais de um arrays, possibilitando a construção de matrizes
   - A base da matriz deve ser obrigatoriamente inicializada no momento de sua declaração, pois é a partir da base
     que uma matriz será construída.
   - Assim como em um array comum, ao acessar um índice da matriz que não esteja inicializado, gerará NullPointerException.
   - Em uma matriz, o array base faz referência para outro array. Por exemplo, uma matriz [2][3], o primeiro [] faz
     referência a 2 arrays de 3 posições. Ou seja, cada posição é um array de 2 posições. */

package com.paulo.modulo01_basico;

public class A036_ArraysMultidimencionais {
    public static void main(String[] args) {
        int[][] meses = new int[12][];
        int[][] matrizDupla = new int[2][2];
        int[][][] matrizTripla = {{{1, 2, 3}, {10, 20, 30}, {100, 200, 300}}, {{1, 2, 3}, {10, 20, 30}, {100, 200, 300}}};

        // System.out.println(meses[0][1]); Erro NullPointerException, pois o índice 1 da matriz é nulo, portanto não é possível acessar um dado em um array nulo.

        meses[0] = new int[2];
        System.out.println(meses[0][1]); // Com o array inicializado é possível acessar seus dados.

        // Percorrendo matriz da forma tradicional
        System.out.println("---- Matriz dupla tradicional ----");
        for(int i = 0; i < matrizDupla.length; i++){
            System.out.printf("Linha %d: ", i);
            for(int j = 0; j < matrizDupla[i].length; j++){
                System.out.printf("%d, ", matrizDupla[i][j]);
            }
            System.out.println();
        }

        // Percorrendo matriz via foreach
        System.out.println("---- Matriz dupla forEach ---");
        for(int[] indice : matrizDupla){
            for(int i : indice){
                System.out.printf("%d, ", i);
            }
            System.out.println();
        }

        /* Diferente da matriz dupla, sabendo que a base da matriz armazena apenas a referência para outros arrays,
           A base não é utilizada no loop, pois ao tentar acessar a base[posição], sempre será um array ou outra
           referẽncia à array, dependendo do tamanho da base. */
        System.out.println("---- Matriz tripla tradicional ----");
        for(int i = 0; i < matrizTripla[0].length; i++) {
            System.out.printf("Índice %d: ", i);
            for (int j = 0; j < matrizTripla[0][i].length; j++) {
                System.out.printf("%d, ", matrizTripla[0][i][j]);
            }
            System.out.println();
        }

        System.out.println("---- Matriz tripla forEach ----");
        for(int[][] indice : matrizTripla){
            for(int[] valor: indice){
                for(int i : valor){
                    System.out.printf("%d, ", i);
                }
                System.out.println("");
            }
            System.out.println("------");
        }
    }
}
