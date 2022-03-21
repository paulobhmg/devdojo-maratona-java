
/* Arrays são estruturas de dados indexadas que possibilitam armazenar vários dados, referenciados por uma única
   variável. O tamanho de um array nunca muda, ou seja, caso queira aumentar a espaço de um array, é necessário criar
   um novo array e copiar os dados do array antigo para o novo.
   Por padrão, ao inicializar um array, os valores contidos em cada index recebe um valor padrão:
   - tipo numérico = 0 se for inteiro ou 0.0 se for float ou double
   - tipo char = u000, que representa um espaço em branco
   - tipo boolean = false
   - tipos referência (objetos) = null
 */

package com.paulo.m01_basico;

public class A033_Arrays {
    public static void main(String[] args) {
        String[] nomes = new String[5];
        int[] arrayTeste;

        // System.out.println(arrayTeste); Assim como uma variável primitiva, um array não pode ser acessado sem ser inicializado.

        // Acessando o index de um Array:
        nomes[0] = "Marilene";
        nomes[1] = "Tiago";
        nomes[2] = "Renato";
        nomes[3] = "Paulo";
        nomes[4] = "Augusto";

        System.out.println(nomes[0]);
        System.out.println(nomes[1]);
        System.out.println(nomes[2]);
        System.out.println(nomes[3]);
        System.out.println(nomes[4]);

         // System.out.println(nomes[5]); Erro. Tamanho do array = 5. O índex máximo = 4.
        System.out.println("--------------------------------------------------");

        int[] numeros1 = new int[2]; // Valores inicializados como 0.
        int[] numeros2 = {3, 4};
        int[] numeros3 = new int[]{5, 6, 7, 8, 9};

        System.out.println("Array 1: ");
        for(int i = 0; i < numeros1.length; i++){
            System.out.printf("Posição %d: %d \n", i, numeros1[i]);
        }

        System.out.println("Array 2: ");
        for(int i = 0; i < numeros2.length; i++){
            System.out.printf("Posição %d: %d \n", i, numeros2[i]);
        }

        /* O forEach é uma simplificação do laço for, para percorrer arrays inteiros. Nesse modelo, é necessário
           declarar uma variável de iteração do mesmo tipo do array que receberá o valor existente em cada index iterado.
           Não é possível referenciar o index 'array[index]', pois o valor contido no index é armazenado na variável
           de iteração implicitamente.
         */
        System.out.println("Array 3: ");
        for(int i : numeros3) {
            System.out.printf("%d, ", i);
        }
    }
}
