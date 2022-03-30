package com.paulo.modulo02_orientacaoObjetos.d.modificador_static;

import com.paulo.modulo02_orientacaoObjetos.d.modificador_static.domain.CarroModificadorEstatico;

public class A062_ModificadorEstatico {
    public static void main(String[] args) {
        CarroModificadorEstatico tcross = new CarroModificadorEstatico("T-Cross");
        CarroModificadorEstatico polo = new CarroModificadorEstatico("Novo Polo");
        System.out.println(tcross);
        System.out.println(polo);

        // Alterando os atributos de instânica dos objetos (Altera apenas o objeto referẽncia )
        tcross.setVelocidadeMaximaInstancia(350);
        polo.setVelocidadeMaximaInstancia(330);
        System.out.println(tcross);
        System.out.println(polo);
        System.out.println("--------------------------");

        // Alterando os atributos estáticos (Altera o atributo em todos os objetos
        CarroModificadorEstatico.velocidadeMaximaClasse = 356;
        System.out.println(tcross);
        System.out.println(polo);
        System.out.println("--------------------------");

        // Alterando atributos estáticos a partir dos métodos estáticos
        CarroModificadorEstatico.setVelocidadeMaximaClasse(300);
        System.out.println(tcross);
        System.out.println(polo);
    }
}
