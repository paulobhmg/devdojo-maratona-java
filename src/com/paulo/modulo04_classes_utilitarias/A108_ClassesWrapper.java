package com.paulo.modulo04_classes_utilitarias;

/* Classes Wrapper encapsulam atributos primários em objetos, permitindo a utilização de métodos e passagem de parâmetro
   por referência, além de permitir a utilização desses tipos em Coleções de dados, o que não é permitido com os tipos
   primitivos. Inicializar um tipo Wrapper com um valor primitivo é conhecido como autoboxing, e quando inicializamos
   um tipo primitivo com o valor de um Wrapper, é conhecido como unboxing. Ambos são feitos implicitamente pelo Java. */
public class A108_ClassesWrapper {
    public static void main(String[] args) {
        // Todas as declarações abaixo são autoboxing.
        Byte byteW = 127;
        Short shortW = 32627;
        Integer integerW = 28829828;
        Long longW = 29828020L;
        Float floatW = 2828.0F;
        Double doubleW = 2883.4D;
        Character charW = 'C';
        Boolean bolleanW = true;

        System.out.println("Byte: " + byteW);
        System.out.println("Short: " + shortW);
        System.out.println("Integer: " + integerW);
        System.out.println("Long: " + longW);
        System.out.println("Float: " + floatW);
        System.out.println("Double: " + doubleW);
        System.out.println("Char: " + charW);
        System.out.println("Boolean: " + bolleanW);
        System.out.println("-----------------------------");

        System.out.println(Boolean.parseBoolean("tRue")); //Retorna se uma String é boolean
        System.out.println(Byte.MAX_VALUE);
        System.out.println("-----------------------------");

        Character specialCharW = '2';
        Character letterCharW = 'F';

        // A classe Character possui métodos diferenciados que podem ser utilizados sob um caractere específico.
        System.out.println(charW.charValue());
        System.out.println("Upper case character special: " + Character.toUpperCase(specialCharW));
        System.out.println("Lower case: " + Character.toLowerCase(charW));
        System.out.println("IsNumber? " + Character.isDigit(specialCharW));
        System.out.println("IsCharacter? " + Character.isLetter(specialCharW));
        System.out.println("IsCharacter? " + Character.isLetter(letterCharW));
    }
}
