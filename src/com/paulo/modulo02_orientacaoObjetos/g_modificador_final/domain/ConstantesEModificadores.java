/* Uma constante é caracterizada pelo uso da palavra reservada FINAL.
   * Constantes do tipo primitivo não poderão ter seu valor alterado.
   * Constantes do tipo referência não poderão ter a referência do objeto alterada, porém os dados do objeto poderão ser alterados
   * Classes FINAL não poderão ser herdadas, consequentemente, seus métodos não serão sobrescritos, visto que não há herança.
   * Métodos FINAL não podem ser sobrescritos em classes filhas.

   * Constantes devem ser inicializadas no momento em que forem declaradas.
   * Como exceção, podem ser inicializadas a partir de blocos de inicalização ou construtores,
     pois entende-se que antes da instanciação de um objeto, ambos já foram executados, quando existirem. */
package com.paulo.modulo02_orientacaoObjetos.g_modificador_final.domain;

// Essa classe não poderá ser estendida, pois é final
public final class ConstantesEModificadores {
    public final double SALARIO_ATUAL = 6850;
    public final double SALARIO_MINIMO_ACEITAVEL;
    public final double SALARIO_BUSCADO;

    {
        SALARIO_MINIMO_ACEITAVEL = 4000;
    }

    public ConstantesEModificadores(){
        SALARIO_BUSCADO = 30000;
    }

    @Override
    public String toString() {
        return "ConstantesPrimitivas{" +
                "SALARIO_ATUAL=" + SALARIO_ATUAL +
                ", SALARIO_MINIMO_ACEITAVEL=" + SALARIO_MINIMO_ACEITAVEL +
                ", SALARIO_BUSCADO=" + SALARIO_BUSCADO +
                '}';
    }

    // Método não poderá ser sobrescrito, pois é final.
    public final double getSalario(){
        return SALARIO_ATUAL;
    }
}
