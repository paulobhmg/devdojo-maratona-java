/* O construtor de uma classe sempre sera o ultimo componente executado ANTES da instanciaçao de um objeto.
   Ultimo pois antes da incializaçao de um construtor tambem sao executados variaveis staticas, valores padroes e
   blocos de codigo.

   Um construtor se parece muito com um metodo, porem, embora nao retorne nenhum valor, nao recebe um void em sua assinatura.
   Recebe apenas um modificador, obrigatoriamente publico, seguido do mesmo nome da Classe.

   Caso nao exista um construtor explicito, o Java cria implicitamente um construtor padrao, sem parametros. Caso existam
   construtores definidos pelo desenvolvedor, e necessario criar um construtor padrao, para instanciar objetos sem atributos.
   Alguns frameworks utilizam um construtor vazio como parametro ou para resoluçao de ambiguidade.

   Um construtor e um componente especifico para instanciaçao de objetos. Quando utilizamos o operador NEW, na atribuiçao
   de um objeto em uma variavel de referencia, essa palavra reservada ira acessar o construtor da classe.
   Diferente do exemplo utilizado na classe Carro, onde primeiro cria-se um objeto e depois utiliza o metodo INIT Para
   inicializar seus atributos, um construtor ja inicializa os atributos no momento da instanciaçao do objeto. */

package com.paulo.modulo02_orientacaoObjetos.b_metodos.domain;

public class Trator {
    private String marca;
    private int ano;

    // Construtor padrao - Nao e necessario criar se nao houver um construtor explicito.
    public Trator(){}

    // Construtor explicito
    public Trator(String marca){
        this.marca = marca;
    }

    // Construtor sobrecarregado. Assim como os metodos, um construtor podera ser sobrecarregado.
    public Trator(String marca, int ano){
        this(marca);
        this.ano = ano;
    }

    public String toString(){
        return "Marca: " + marca + ", ano: " + ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
}
