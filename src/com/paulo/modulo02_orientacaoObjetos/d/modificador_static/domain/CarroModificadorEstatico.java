/* Atributos estáticos não são pertencentes a um objeto e não podem ser referenciados pelo THIS.
   No geral, são atributos da prória classe, que podem ser referenciados mesmo que não exista um objeto instanciado.

   Da mesma forma, métodos estáticos não são capazes de acessar atributos de instância, pois em suma, podem existir
   e ser utilizados sem que exista um objeto instanciado.

   Uma instância de uma classe poderá acessar diretamente esses atributos, porém é importante saber que caso um atributo
   estático seja alterado a partir de um objeto, a alteração será refletida em todos as instâncias da classe, pois
   o atributo estático será alterado na classe, que poderá ser acessado a partir de qualquer outro.

   Portanto, é boa prática determinar atributos estáticos como constantantes ou utilizar métodos estáticos para manipulá-los. */

package com.paulo.modulo02_orientacaoObjetos.d.modificador_static.domain;

public class CarroModificadorEstatico {
    private String modelo;
    private double velocidadeMaximaInstancia = 250;
    public static double velocidadeMaximaClasse = 300;

    public CarroModificadorEstatico(){}

    public CarroModificadorEstatico(String modelo){
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getVelocidadeMaximaInstancia() {
        return velocidadeMaximaInstancia;
    }

    public void setVelocidadeMaximaInstancia(double velocidadeMaximaInstancia) {
        this.velocidadeMaximaInstancia = velocidadeMaximaInstancia;
    }

    public String toString(){
        return String.format("Modelo: %s, VMInstancia: %.2f, VMClasse: %.2f", this.modelo, this.velocidadeMaximaInstancia, velocidadeMaximaClasse);
    }

    public static void setVelocidadeMaximaClasse(double velocidadeMaximaClasse){
        CarroModificadorEstatico.velocidadeMaximaClasse = velocidadeMaximaClasse;
    }
}
