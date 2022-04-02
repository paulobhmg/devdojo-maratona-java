package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.domain;

import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.classes_abstratas.FuncionarioAbstrato;
import com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.interfaces.IVendas;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends FuncionarioAbstrato implements IVendas {
    List<FuncionarioAbstrato> funcionarios;

    {
        funcionarios = new ArrayList<FuncionarioAbstrato>();
    }

    public Gerente(){
        super();
    }

    public Gerente(String nome, double salario){
        super(nome, salario);
    }

    @Override
    public void imprime() {
        System.out.printf(
            "Nome: %s, Cargo: %s, Salario: R$ %.2f, Comissao: %.1f%%, Recebido: R$ %.2f\nVendedores: %d.\n",
             nome, getClass().getSimpleName(), salario, comissao, calculaComissao(), funcionarios.size()
        );
    }

    @Override
    public void vender(double valor) {

    }

    @Override
    public double calculaComissao() {
        double calculo = 0;
        for (FuncionarioAbstrato funcionario : funcionarios) {
            if(funcionario instanceof Vendedor){
                calculo += ((Vendedor) funcionario).getVendas();
            }
        }
        return calculo * comissao;
    }

    public void contratar(FuncionarioAbstrato funcionario){
        if(funcionarios.contains(funcionario)){
            System.out.println("Funcinário já é subordinado de " + nome + ".");
            return;
        }
        funcionarios.add(funcionario);
        ((Vendedor) funcionario).setGerente(this);
    }

    public void demitir(FuncionarioAbstrato funcionario){
        if (!funcionarios.contains(funcionario)) {
            System.out.println("Este funcionário não faz parte da equipe de " + nome + ".");
            return;
        }
        funcionarios.remove(funcionario);
        ((Vendedor) funcionario).setGerente(null);
    }
}
