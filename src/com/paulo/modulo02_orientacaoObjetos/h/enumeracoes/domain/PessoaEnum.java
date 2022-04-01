package com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.domain;

import com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.enumeracoes.TipoDePagamento;
import com.paulo.modulo02_orientacaoObjetos.h.enumeracoes.enumeracoes.TipoDePessoa;

public class PessoaEnum {
    private String nome;
    private TipoDePessoa tipoDePessoa;
    private TipoDePagamento tipoDePagamento;

    public PessoaEnum(){}

    public PessoaEnum(String nome, TipoDePessoa tipoDePessoa, TipoDePagamento tipoDePagamento){
        this.nome = nome;
        if(validaCampos(tipoDePessoa, tipoDePagamento)) {
            this.tipoDePessoa = tipoDePessoa;
            this.tipoDePagamento = tipoDePagamento;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoDePessoa getTipoDePessoa() {
        return tipoDePessoa;
    }

    public void setTipoDePessoa(TipoDePessoa tipoDePessoa) {
        this.tipoDePessoa = tipoDePessoa;
    }

    public TipoDePagamento getTipoDePagamento() {
        return tipoDePagamento;
    }

    public void setTipoDePagamento(TipoDePagamento tipoDePagamento) {
        this.tipoDePagamento = tipoDePagamento;
    }

    public String toString(){
        return nome + ", " + tipoDePessoa + ", " + tipoDePagamento;
    }

    public boolean validaTipoDePessoa(TipoDePessoa tipoDePessoa){
        return tipoDePessoa.equals(TipoDePessoa.PESSOA_FISICA) || tipoDePessoa.equals(TipoDePessoa.PESSOA_JURIDICA);
    }

    public boolean validaTipoDePagamento(TipoDePagamento tipoDePagamento){
        return tipoDePagamento.equals(TipoDePagamento.DEBITO) || tipoDePagamento.equals(TipoDePagamento.CREDITO)
               || tipoDePagamento.equals(TipoDePagamento.BOLETO);
    }

    public boolean validaCampos(TipoDePessoa tipoDePessoa, TipoDePagamento tipoDePagamento){
        if(!validaTipoDePessoa(tipoDePessoa)){
            System.out.println("Tipo de pessoa inválida.");
            if(!validaTipoDePagamento(tipoDePagamento)){
                System.out.println("Tipo de pagamento invalido.");
            }
            return false;
        }else if(!validaTipoDePagamento(tipoDePagamento)){
            System.out.println("Tipo de pagamento invalido.");
            if(!validaTipoDePessoa(tipoDePessoa)){
                System.out.println("Tipo de pessoa invalido.");
            }
            return false;
        }
        return true;
    }
}
