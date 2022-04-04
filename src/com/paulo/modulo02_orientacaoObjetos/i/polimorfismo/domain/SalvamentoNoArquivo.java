package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.classes_abstratas.Salvamento;

public class SalvamentoNoArquivo extends Salvamento {
    @Override
    public void salvar() {
        System.out.printf("Salvando objeto em arquivo...");
    }
}
