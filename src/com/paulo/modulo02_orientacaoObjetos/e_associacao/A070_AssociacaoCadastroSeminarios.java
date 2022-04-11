/* Associação é utilizada para construir relacionamentos entre os objetos. Ou seja, um objeto poderá referenciar
   outros objetos, que serão considerados instâncias dentro do objeto ao qual este é um atributo.

   No exemplo, um Seminário possui um Professor, um Local e uma lista de alunos, sendo que cada um desses itens é um
   objeto que será associado a um Seminário.

   Neste caso, é interessante observar que a associação poderá ser unilateral ou bilateral, como é o caso de um aluno,
   que possui como atributo uma lista de seminários, enquanto um seminário também possui uma lista de alunos, ou
   um professor, que possui uma lista de seminários, enquanto um seminário possui apenas um professor, neste caso, sendo
   uma associação unilateral de professor para seminário e bilateral de seminário para professor */

package com.paulo.modulo02_orientacaoObjetos.e_associacao;

import com.paulo.modulo02_orientacaoObjetos.e_associacao.domain.Aluno;
import com.paulo.modulo02_orientacaoObjetos.e_associacao.domain.Local;
import com.paulo.modulo02_orientacaoObjetos.e_associacao.domain.Professor;
import com.paulo.modulo02_orientacaoObjetos.e_associacao.domain.Seminario;

public class A070_AssociacaoCadastroSeminarios {
    public static void main(String[] args) {
        Aluno paulo = new Aluno("Paulo");
        Professor juliano = new Professor("Juliano", "Java");
        Local pbh = new Local("Laboratório", "Avenida Augusto de Lima", 30, "Centro");
        Seminario seminarioJava = new Seminario("Java Web + Springboot", "30/03/2022", pbh, juliano);

        System.out.println(juliano);

        System.out.println(seminarioJava);
        System.out.println("----------------------");

        System.out.println(pbh);
        System.out.println("----------------------");

        System.out.println(paulo);
        System.out.println("----------------------");

        paulo.participarDeSeminario(seminarioJava);
        System.out.println(seminarioJava);
        System.out.println("----");

        System.out.println(paulo);

        paulo.sairDoSeminario(seminarioJava);
        System.out.println(seminarioJava);
        paulo.sairDoSeminario(seminarioJava);
        System.out.println("-------");

        System.out.println(paulo);
    }
}
