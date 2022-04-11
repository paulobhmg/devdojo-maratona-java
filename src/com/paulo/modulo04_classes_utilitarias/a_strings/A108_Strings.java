package com.paulo.modulo04_classes_utilitarias.a_strings;

/* String são armazenadas em um local diferente na memória do Java. Enquanto os objetos são armazenados em um local chamado
   Heap, as Strings são armazenadas em um local chamado String constant pool.

   Strings são imutáveis, ou seja, seu não pode ser alterado. Quando há a necessidade de alterar o valor de uma String,
   deverá ser feita uma nova atribuição de valor ou criar uma nova String com um novo valor. Para otimização de performance,
   o Java não cria Strings iguais no Pool de Strings. Isso significa que quando criamos uma String com o nome "Paulo",
   por exemplo, se criar outra variável de referência que recebe esse mesmo nome, não será criada outra String "Paulo" no
   pool de Strings, ou seja, a nova variável fará referência para o mesmo "Paulo", já existente.

   Strings criadas como Objetos, utilizando o operador new, não serão consideradas iguais  a uma String declarada como
   literal. Isso acontece por que ao criar uma String nesse formato, é criado um objeto, que terá como valor uma String,
   que por sua vez fará referência a uma String criada no pool de strings.*/
public class A108_Strings {
    public static void main(String[] args) {
        String nome = "Paulo";
        String nome2 = "Nogueira";

        // Quando verificamos se uma String é igual a outra, o que é comparado é o valor da String.
        System.out.println(nome == nome2);
        System.out.println(nome.equals(nome2));
        System.out.println("-------------------");

        // Ao concatenar uma String, o valor não é alterado. É criado uma nova String.
        nome2 = nome.concat(" ").concat(nome2);
        System.out.println(nome2);
        System.out.println("-------------------");

        // Ao criar um objeto do tipo string, mesmo que tenha nome igual, não será a mesma referência.
        String nome3 = new String("Paulo");
        System.out.println(nome3 == nome);
        System.out.println(nome3.equals(nome)); // O Equals verifica o valor da String

    }
}
