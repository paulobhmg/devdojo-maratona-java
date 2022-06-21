package com.paulo.modulo09_classes_internas;

/* Utilizamos classes anônima quando queremos alterar o comportamento de um objeto ou funcionalidade do sistema,
   porém sem que seja necessário criar uma nova classe, ou seja, na maioria das vezes são códigos que não precisarão ser
   reutilizados ou que há apenas a necessidade de alterar o comportamento para um trecho específico de código.
   Classes anônimas foram criadas para lidar com os eventos do java em aplicações Swing.  */

import com.paulo.modulo02_orientacaoObjetos.b_metodos.domain.Carro;
import com.paulo.modulo02_orientacaoObjetos.b_metodos.domain.Trator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class A191_ClassesAnonimas {

    public static void main(String[] args) {

        /* A forma como esse carro está sendo instanciado é um exemplo do uso de uma classe anônima. Basicamente estamos
           instanciando um novo objeto do tipo Trator, porém após a abertura das chaves, sobrescrevemos o método andar(),
           que so funcionara dessa maneira enquanto este objeto persisitir na memoria. Apos a execuçao do codigo a classe
           anonima nao existira mais. */
        Trator trator = new Trator("Tractor", 1998) {
            @Override
            public void andar() {
                this.setVelocidadeAtual(this.getVelocidadeAtual() + 15);
                reduzir();
            }

            /* É possível adicionar à uma classe anônima instanciada dessa maneira, novos métodos, porém esses métodos
               só poderão ser acessados de dentro da classe anônima. Isso acontece pois a classe Trator não conhece esse
               método, logo, a variável que está fazendo referência a este objeto também não conhecerá. */
            public void reduzir() {
                this.setVelocidadeAtual(this.getVelocidadeAtual() - 10);
            }
        };

        trator.andar();
        trator.andar();
        System.out.println(trator);

        // System.out.println(trator.reduzir()); // A classe Trator não conhece esse método.

        System.out.println("-------------------------------");

        /* Em um exemplo mais real, uma classe anônima poderá ser utilizada para instanciar uma interface, que, neste caso,
           poderá ser instanciada (interfaces não são instanciadas). */

        List<Trator> tractors = new ArrayList<>(
                List.of(
                        new Trator("Furacão", 1998), new Trator("Rinomotto", 2001), new Trator("Bixão", 1981)
                )
        );
        System.out.println(tractors);

        // Neste exemplo, uma classe anônima poderá ser utilizada para instanciar um Comparator diretamente na chamada do método sort().
        tractors.sort(new Comparator<Trator>() {
            @Override
            public int compare(Trator t1, Trator t2) {
                return Integer.compare(t1.getAno(), t2.getAno());
            }
        });

        System.out.println("Lista ordenada: " + tractors);

        // Outra forma de definir um Comparator e a partir de expressoes lambdas, assunto futuro.
        tractors.sort((t1, t2) -> t1.getMarca().compareToIgnoreCase(t2.getMarca()));
        System.out.println("Lista ordenada por nome: " + tractors);
    }
}
