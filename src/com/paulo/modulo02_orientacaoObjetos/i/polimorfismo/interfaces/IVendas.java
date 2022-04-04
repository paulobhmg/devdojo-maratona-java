package com.paulo.modulo02_orientacaoObjetos.i.polimorfismo.interfaces;

public interface IVendas {

    //É permitido criar atributos em interface. Por padrão, são SEMPRE constantes estáticas e devem ser inicializadas.
    int TESTE = 10;

    void vender(double valor);

    double calculaComissao();

    /* Métodos DEFAULT permitem criar métodos com corpo que, diferente dos métodos abstratos, não é obrigatório a
       sobrescrita do método. */
    default void test() {
    }

    /* A partir do Java8 também é possível criar métodos estáticos. Esses não poderão ser sobrescritos, pois pertencem
      a classe e assim como métodos default, devem ter um corpo em sua definição. */
    static void testeAbstrato() {
    }
}
