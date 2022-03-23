package com.paulo.modulo02_orientacaoObjetos.a.introducao;

import com.paulo.modulo02_orientacaoObjetos.a.introducao.domain.Funcionario;

public class A053_ExercicioGeral {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Paulo", 29);
        Funcionario funcionario2 = new Funcionario("Giuseppe", 31, 3000, 2700, 2300);

        System.out.println(funcionario);
        System.out.println(funcionario2);

        System.out.println(funcionario.getMediaSalarial());
        System.out.println(String.format("%.2f", funcionario2.getMediaSalarial()));
        System.out.println("----------------------------");

        funcionario.setUltimosSalarios(1690, 3400, 7000);
        System.out.println(funcionario);
        System.out.println(String.format("%.2f", funcionario.getMediaSalarial()));

    }
}
