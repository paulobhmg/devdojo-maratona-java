package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.classes_abstratas.Salvamento;

public class SalvamentoNoBanco extends Salvamento {
    @Override
    public void salvar() {
        System.out.println("Salvando objeto no banco...");
    }
}
