package com.paulo.modulo02_orientacaoObjetos.a_introducao.domain;

public class Funcionario {
    private String nome;
    private int idade;
    private double[] ultimosSalarios;

    public Funcionario(){}

    public Funcionario(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Funcionario(String nome, int idade, double... ultimosSalarios) {
        this.nome = nome;
        this.idade = idade;
        this.ultimosSalarios = ultimosSalarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getUltimosSalarios() {
        return ultimosSalarios;
    }

    public void setUltimosSalarios(double... ultimosSalarios) {
        this.ultimosSalarios = ultimosSalarios;
    }

    /* Conforme comentado no módulo 01, não é possível acessar os indexes de arrays nulos ou que não foram inicialiados.
       Neste caso, se tentar imprimir os dados de um funcionário que não tem o array de salários inicializado, gerará
       exceção NullPointerException. Para previnir evitar que este erro aconteça, uma prática de programação defensiva
       pode ser aplicada no método, definindo uma ação para caso o array esteja vazio. Outra possível forma de contornar
       é inicializando esse atributo no momento da instanciação do objeto. */
    public String toString(){
        StringBuilder texto = new StringBuilder();
        texto.append(String.format("%s, %d anos.\n", nome, idade)).append("Salários: ");
        if(this.ultimosSalarios != null){
            for(int i = 0; i < this.ultimosSalarios.length; i++){
                texto.append(this.ultimosSalarios[i]);
                if(i < this.ultimosSalarios.length -1){
                    texto.append(", ");
                }
            }
            texto.append("\n").append(String.format("Média Salarial: %.2f", getMediaSalarial()));
        } else{
            texto.append("Ainda não informado.");
        }
        texto.append("\n---------------------");
        return texto.toString();
    }

    // Aqui, já que o cálculo da média depende dos valores de salários, é necessário verificar se o array está nulo.
    public double getMediaSalarial(){
        double soma = 0;
        if(this.ultimosSalarios == null){
            System.out.println("Nenhum salário informado para " + this.nome);
            return 0;
        }
        for(double salario : this.ultimosSalarios){
            soma += salario;
        }
        return soma / this.ultimosSalarios.length;
    }
}
