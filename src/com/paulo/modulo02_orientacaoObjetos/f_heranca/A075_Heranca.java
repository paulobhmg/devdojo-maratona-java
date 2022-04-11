package com.paulo.modulo02_orientacaoObjetos.f_heranca;

import com.paulo.modulo02_orientacaoObjetos.f_heranca.domain.Endereco;
import com.paulo.modulo02_orientacaoObjetos.f_heranca.domain.Funcionario;

public class A075_Heranca {
    public static void main(String[] args) {
        Funcionario paulo = new Funcionario("Paulo", 29, 6850);
        System.out.println(paulo);

        Endereco endereco = new Endereco("Rua Frei Orlando", "1035 - Apto 201", "Caiçaras");
        Funcionario marilene = new Funcionario("Marilene", 59, 5800, endereco);
        System.out.println(marilene);

        paulo.setEndereco(endereco);
        System.out.println(paulo);
    }
}
