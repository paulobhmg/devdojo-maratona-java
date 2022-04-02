package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.classes_abstratas.FuncionarioAbstrato;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.interfaces.IVendas;

public class Vendedor extends FuncionarioAbstrato implements IVendas {
    private Gerente gerente;
    private double vendas;

    public Vendedor(){
        super();
    }

    public Vendedor(String nome, double salario){
        super(nome, salario);
    }

    public Vendedor (String nome, double salario, Gerente gerente){
        super(nome, salario);
        this.gerente = gerente;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    @Override
    public void imprime() {
        System.out.printf(
            "Nome: %s, Cargo: %s, Salário: R$ %.2f, Vendas: R$ %.2f, Comissao: %.2f%%, Recebido: R$ %.2f.\nGerente: %s.\n",
            nome, getClass().getSimpleName(), salario, vendas, comissao, calculaComissao(), gerente != null ? gerente.getNome() : "Não definido"
        );
    }

    @Override
    public void vender(double valor) {
        vendas += valor;
    }

    @Override
    public double calculaComissao() {
       return vendas * comissao;
    }
}
