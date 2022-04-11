package com.paulo.modulo02_orientacaoObjetos.b_metodos.domain;

public class Carro {
    private String modelo;
    private String cor;

    public void init(String modelo) {
        this.modelo = modelo;
    }

    /* Quando criamos métodos que alteram o estado do objeto, caso surjam alterações nos requisitos, que façam com que seja
       necessário alterar a assinatura de um método já referenciado em outras partes do programa, poderá haver a quebra
       do programa, pois será necessário alterar o código em todos os locais que fizeram chamada àquele método.

       Quando há tal necessidade, há a possibilidade de criar um novo método, com o mesmo nome, porém com tipos de
       retorno, tipos de parâmetros ou até mesmo o número de parâmetros diferentes. */
   public void init(String modelo, String cor){
       this.init(modelo);
       this.cor = cor;
   }

   // Sendo assim, não é boa prática criar um método com nome diferente apenas para adicionar um parâmetro, como abaixo.
   public void init2(String modelo, String cor){
       this.modelo = modelo;
       this.cor = cor;
   }

    public String getModelo() {
        return modelo;
    }

    /* Todos os Objetos Java são filhos de Object, que possui alguns métodos, herdados para as classes filhas. Neste caso,
       todos vão possuir o método toString, que possui comportamento padrão, definidos na classe Object. No exemplo abaixo,
       estamos definindo um novo meodo toString(), passando um novo corpo para o método.

       Sendo assim, aqui está ocorrendo a sobrescrita do método, que é, basicamente, alterar o comportamento do método
       na classe filha. Na sobrescrita não há alteração na assinatura do método, mas sim no seu corpo. */
    public String toString() {
        return "Modelo: " + modelo + ", cor: " + cor;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}

/* De forma resumida, temos que:
   Sobrecarga é quando existem dois métodos com o mesmo nome, mas com assinaturas diferentes.
   Sobrescrita é quando há a alteração compartamental do método herdado. Neste caso não há alteração na assinatura do método.
 */