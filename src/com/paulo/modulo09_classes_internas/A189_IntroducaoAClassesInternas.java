package com.paulo.modulo09_classes_internas;

import com.paulo.modulo09_classes_internas.domain.OuterClass;


/* Uma classe interna é utilizada quando há a divisão entre atributos e comportamentos em uma classe.
   Por exemplo, em uma interface de um caixa eletrônico, a classe principal é responsável pelo domínio CaixaEletronico,
   enquanto a classe interna é responsável pelas ações executadas na classe de domínio. São dois objetos diferentes, com
   responsabilidades diferentes, dentro da mesma classe.

   Classes internas são bastante utilizadas para instanciação de objetos, através do padrão de projetos Builder. */
public class A189_IntroducaoAClassesInternas {

    public static void main(String[] args) {
        /* Para instanciar uma classe interna, é necessário instanciar primeiro um objeto externo, pois uma classe
           interna só existirá caso exista uma instância da classe externa. */

        // Vale observar aqui que a classe externa não tem acesso aos atributos da classe interna.
        OuterClass outer = new OuterClass();
        System.out.println(outer.getOuterClassName());

        // Como dito, é necessário que haja uma instância da classe externa para criar a classe interna.
        OuterClass.InnerClass innerClass = outer.new InnerClass();
        innerClass.printOuterClassAttributes();
    }
}
