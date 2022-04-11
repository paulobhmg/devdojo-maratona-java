package com.paulo.modulo04_classes_utilitarias.a_strings;

/* Quando trabalhamos com Strings muito grandes ou quando é necessário efetuar várias operações com Strings, temos
   uma perda de performance. Para isso, temos as classes StringBuilder e StringBuffer, que trabalham melhor quando
   há a necessidade de grandes quantidades de processamento de textos.

   Ambas as classes possuem os mesmos métodos, com a diferença que StringBuffer foi desenvolvida para trabalhos
   em sistemas multi-treading. Em relação a essas duas, quanto maior a quantidade de dados, melhor é a performance do
   StringBuilder em relação à StringBuffer.

   ** Alguns detalhes importantes sobre StringBuilder e StringBuffer:
    1 - Não são Strings, ou seja, não criam uma String no pool de Strings.
    2 - Por não serem Strings, não são imutáveis, ou seja, ou método APPEND está alterando o seu texto.
    3 - É importante observar quando utiliza-se os métodos que são utilizados em STrings, como por exemplo o substring.
        Esse método manipula uma String, ou seja, retornará uma nova String que deverá ser adicionada ao StringBuilder
        caso o objetivo seja manipulá-lo.
    4 - Seu construtor é sobrecarregado, podendo receber uma String, uma sequencia de caracteres ou até mesmo um int
        informando a quantidade de caracteres que terá capacidade de armazenar. */
public class A110_Performance {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        concatenaString(100_000);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para String: " + (fim - inicio) + "ms.");
        System.out.println("-----------------------------------");

        inicio = System.currentTimeMillis();
        concatenaStringBuilder(50_000_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder: " + (fim - inicio) + "ms.");
        System.out.println("-----------------------------------");

        inicio = System.currentTimeMillis();
        concatenarStringBuffer(50_000_000);
        fim = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer: " + (fim - inicio) + "ms.");
        System.out.println("-----------------------------------");
    }

    public static void concatenaString(int quantidade){
        String valor = "";
        for(int i = 0; i <= quantidade; i++){
            valor += quantidade;
        }
    }

    public static void concatenaStringBuilder(int quantidade){
        StringBuilder valor = new StringBuilder(quantidade); // O construtor está recebendo a quantidade de caracters suportado.
        for(int i = 0; i <= quantidade; i++){
            valor.append(quantidade);
        }
    }

    public static void concatenarStringBuffer(int quantidade){
        StringBuffer valor = new StringBuffer();
        for(int i = 0; i <= quantidade; i++){
            valor.append(quantidade);
        }
    }
}
