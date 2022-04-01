package com.paulo.modulo02_orientacaoObjetos.g.modificador_final;

import com.paulo.modulo02_orientacaoObjetos.f.heranca.domain.Pessoa;
import com.paulo.modulo02_orientacaoObjetos.g.modificador_final.domain.ConstantesEModificadores;

public class A079_ModificadorFinal {
    public static void main(String[] args) {
        ConstantesEModificadores primitivas = new ConstantesEModificadores();
        System.out.println(primitivas);
        // primitivas.SALARIO_ATUAL *= 0.1175; -- Erro. O valor de uma constante primitiva não pode ser alterado.

        final Pessoa pessoa = new Pessoa("Paulo",29);
        System.out.println(pessoa);
        // pessoa = new Pessoa("Paulo", 29); -- Erro. Não é possível alterar a referência de constantes Referência.
    }
}
