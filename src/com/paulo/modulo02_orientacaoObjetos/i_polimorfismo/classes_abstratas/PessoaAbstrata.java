/* Classes abstratas são classes que NUNCA serão instanciadas. Uma classe abstrata será genérica, ou seja, servirá como
   modelo para a criação de classes filhas, especializadas, que herdarão seus atributos e métodos. Sendo assim, uma classe
   abstrata define um conjunto de informações comuns entre outras classes.

   Os métodos abstratos só podem ser definidos em classes abstratas e não possuem um corpo em sua definição. Mas o que é
   um método abstrato? Basicamente, dizer que um método é abstrato, significa dizer que ele obrigatoriamente deverá ser
   sobrescrito na classe concreta, filha da classe abstrata.

   Se a classe que herda uma classe abstrata também for abstrata, não é obrigado a implementar o método, pois ela é abstrata.
   As classes CONCRETAS éh quem tem obrigação de implementar o método abstrato.  */

package com.paulo.modulo02_orientacaoObjetos.i_polimorfismo.classes_abstratas;

public abstract class PessoaAbstrata {
    protected String nome;

    public PessoaAbstrata(){}

    public PessoaAbstrata(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // O método abstrato não contem corpo. Esse método deverá ser sobrescrito na primeira classe concreta dessa linhagem.
    public abstract void imprime();
}
