package com.paulo.modulo02_orientacaoObjetos.h.enumeracoes;

import com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.domain.PessoaEnum;
import com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.enumeracoes.TipoDePagamento;
import com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.enumeracoes.TipoDePessoa;

public class A082_TestaEnumeracoes {
    public static void main(String[] args) {
        PessoaEnum pessoa = new PessoaEnum("Paulo", TipoDePessoa.PESSOA_FISICA, TipoDePagamento.BOLETO);
        System.out.println(pessoa);
        PessoaEnum pessoa2 = new PessoaEnum("Augusto", TipoDePessoa.PESSOA_JURIDICA, TipoDePagamento.TESTE);
        PessoaEnum pessoa3 = new PessoaEnum("Jerundino", TipoDePessoa.PESSOA_INVALIDA, TipoDePagamento.TESTE);

        TipoDePagamento tipoPagamento = pessoa.getTipoDePagamento().getPagamento("Pessoa física");
    }
}
