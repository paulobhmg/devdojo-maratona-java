/* Utilizamos Herança quando queremos estender as funcionalidades de uma classe para outra ou quando queremos utilizar
   o polimorfismo. Uma classe que herda as funcionalidades de outra terá acesso aos mesmos atritubos e métodos existentes
   na classe pai.

   Neste caso, temos o relacionamento É UM. Ou seja, classes filhas também são do mesmo tipo da classe pai e elas
   poderão ser referenciadas da mesma forma que as classes pai. Isso permite que várias ações sejam executadas para classes
   do mesmo tipo, porém com particularidades.

   As classes filhas terão acesso a todos os atributos definidos como PROTECTED. Atributos privados serão visíveis
   apenas na classe pai e não serão disponibilizados para as classes filhas.

   ** Ao utilizar o polimorfismo, é importante entender que as classes filhas tem acesso aos atributos da classe pai,
   porém, a classe pai não tem acesso aos atributos das classes filhas, pois elas são classes especializadas, com
   atributos próprios.

   Os atritubos e métodos da classe pai não precisarão ser repetidos na classe filha. Caso sejam explicitados nas
   classes filhas, eles serão sobrescritos. */
package com.paulo.modulo02_orientacaoObjetos.f.heranca.domain;

public class Pessoa {
    protected String nome;
    protected int idade;
    protected Endereco endereco;
    private String codigoClassePessoa = "4b26";

    public Pessoa(){}

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public Pessoa(String nome, int idade, Endereco endereco) {
        this(nome, idade);
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCodigoClassePessoa() {
        return codigoClassePessoa;
    }

    public void setCodigoClassePessoa(String codigoClassePessoa) {
        this.codigoClassePessoa = codigoClassePessoa;
    }

    public String toString(){
        StringBuilder descricao = new StringBuilder();
        descricao.append(String.format("Nome: %s, idade: %d.\n", nome, idade));
        descricao.append(String.format("Endereço: %s", endereco != null ? endereco : "Não informado"));
        return descricao.toString();
    }
}
