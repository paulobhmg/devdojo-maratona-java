/* A classe filha tem acesso a todos os atributos e métodos da classe pai e não é necessário criá-los aqui.
   Caso crie os métodos novamente, haverá a sobrescrita do método, ou seja, o comportamento do método será alterado na
   classe filha.

   Caso seja necessário ADICIONAR COMPORTAMENTO EXTRA, além do que existe na classe pai, pode-se utilizar a palavra
   reservada SUPER. Essa palavra faz referência aos métodos da classe pai. OU seja, sempre que chamar a palavra SUPER,
   estará na verdade executando o método definido dentro da classe pai. Esses métodos poderão ser métodos comuns ou
   construtores. */
package com.paulo.modulo02_orientacaoObjetos.f.heranca.domain;

public class Funcionario extends Pessoa {
    private double salario;

    public Funcionario(){
        super();
    }

    public Funcionario(String nome, int idade, double salario){
        super(nome, idade);
        this.salario = salario;
    }

    public Funcionario(String nome, int idade, double salario, Endereco endereco){
        super(nome, idade, endereco);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /* Neste caso, ao definir o método toString() nesta classe, estamos alterando o comportamento herdado da classe pai,
       e como é necessário imprimir os dados de funcionário, que é uma pessoa, utilizamos a palavra reservada SUPER, que imprime
       os dados da pessoa, e neste método estamos apenas adicionando ao texto o salário do funcionário. */
    public String toString(){
        StringBuilder descricao = new StringBuilder();
        descricao.append(super.toString());
        descricao.append("\n");
        descricao.append(String.format("Salário: %.2f", salario));
        return descricao.toString();
    }
}
