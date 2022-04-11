package com.paulo.modulo04_classes_utilitarias.a_strings;

/* Uma String provê métodos que permitem fazer transformações dos valores. */
public class A109_MetodosUteis {
    public static void main(String[] args) {
        String nome = "Paulo";
        String sobrenome = "Nogueira";
        String profissao = "Analista de Sistemas";
        double salario = 6850;
        String descricao = nome.concat(" ").concat(sobrenome).concat(", ").concat(profissao).concat(", R$ ").concat(String.format("%.2f", salario));

        System.out.println(descricao);

        System.out.println("Replace u por U: " + descricao.replace("u", "U"));
        System.out.println("Substring nome: " + descricao.substring(0, descricao.indexOf(" ")));
        System.out.println("Posição do segundo caracter espaço: " + descricao.indexOf(" ", descricao.indexOf(" ") + 1));
        System.out.println("Posição do último caracter espaço: " + descricao.lastIndexOf(" "));
        System.out.println(descricao.charAt(3));
    }
}
