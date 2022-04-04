package com.paulo.modulo03_tratamento_de_erros;

/* As exceções podem ser do tipo Checked ou Unchecked.
   Exceções Unchecked são aquelas que ocorrem em tempo de execução. Normalmente ocorrem quando há um erro inesperado
   que não foi previsto pelo desenvolvedor - um erro de lógica. Sendo assim, o código é compilado sem erros e executado
   ormalmente. Caso uma exceção seja lançada, finaliza a execução do programa, caso não seja tratada. */
public class A096_RuntimeException {
    public static void main(String[] args) {
        // Ao tentar acessar propriedades de um objeto NULO por exemplo, temos a exceção NullPointerException.
        Object obj = null;
        System.out.println(obj.toString());

        // Ao acessar o índex que não existe em um Array, temos a exceção ArrayIndexOutOfBoundsException
        int[] array = {1,2};
        System.out.println(array[3]);

        // Ao tentar dividir um valor por zero, temos a exceção ArithmeticException
        int divisao = 10/0;
        System.out.println(divisao);
    }
}
