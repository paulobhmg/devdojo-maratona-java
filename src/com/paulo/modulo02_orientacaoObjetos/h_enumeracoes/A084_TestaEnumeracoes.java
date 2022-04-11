package com.paulo.modulo02_orientacaoObjetos.h_enumeracoes;

import com.paulo.modulo02_orientacaoObjetos.h_enumeracoes.domain.PessoaEnum;
import com.paulo.modulo02_orientacaoObjetos.h_enumeracoes.enumeracoes.TipoDePagamento;
import com.paulo.modulo02_orientacaoObjetos.h_enumeracoes.enumeracoes.TipoDePessoa;

public class A084_TestaEnumeracoes {
    public static void main(String[] args) {
        PessoaEnum pessoa = new PessoaEnum("Paulo", TipoDePessoa.PESSOA_FISICA, TipoDePagamento.DEBITO);
        PessoaEnum pessoa2 = new PessoaEnum("Augusto", TipoDePessoa.PESSOA_JURIDICA, TipoDePagamento.BOLETO);
        double descontoDebito = pessoa.getTipoDePagamento().calculaDesconto(300);
        double descontoBoleto = pessoa2.getTipoDePagamento().calculaDesconto(300);

        System.out.println(descontoDebito);
        System.out.println(descontoBoleto);

        /* VERIFICAR ESSE MÉTODO DEPOIS
         TipoDePagamento tipoDePagamento = pessoa.getTipoDePagamento().getPagamento("Boleto");
         System.out.println(tipoDePagamento);
        */
    }
}
