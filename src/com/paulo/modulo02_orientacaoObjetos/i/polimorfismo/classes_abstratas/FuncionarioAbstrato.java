package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.classes_abstratas;

// Para este exemplo a classe funcionário será abstrata
public abstract class FuncionarioAbstrato extends PessoaAbstrata{
    protected double comissao;
    protected double salario;

    public FuncionarioAbstrato(){
        super();
    }

    public FuncionarioAbstrato(String nome, double salario){
        super(nome);
        this.salario = salario;
    }

    public FuncionarioAbstrato(String nome, double salario, double comissao){
        this(nome, salario);
        this.comissao = comissao;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
