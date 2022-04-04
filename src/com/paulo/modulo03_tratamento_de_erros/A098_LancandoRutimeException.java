package com.paulo.modulo03_tratamento_de_erros;

/* Em uma lógica que efetua um cálculo de uma divisão por zero, por exemplo, logicamente haverá uma exceção em tempo de execução.
   Neste caso, quando essa possibilidade está prevista, pode ser tratada diretamente no momento da execução do cálculo, ou pode ser
   tratada no programa que fez a chamada para a execução do código.

   Um detalhe importante é que para as exceções do tipo Unchecked, caso não sejam tratadas dentro do método, não é
   obrigatório adicionar o THROWS em sua assinatura, mas caso contenha, informará para quem chama o método de cálculo
   que ele poderá gerar uma exceção. */
public class A098_LancandoRutimeException {
    public static void main(String[] args) {
        double divisaoTratandoExcecao;
        double divisaoLancadaSemTratarExcecao = 0;
        double divisaoSemTratarErro = 0;

        divisaoTratandoExcecao = calculaTratandoAExcecao(10, 0);
        System.out.println(divisaoTratandoExcecao);

        try {
           divisaoLancadaSemTratarExcecao = calculaSemTratarELancaExcecao(10, 0);
        }catch(RuntimeException e){
            e.printStackTrace();
        }
        System.out.println("Valor após a execução do try: " + divisaoLancadaSemTratarExcecao);

        divisaoSemTratarErro = calculaSemTratar(10, 0);
        System.out.println(divisaoSemTratarErro); // Retorna infinity, pois não houve tratativa para o argumento 0.
    }

    // Obs: O erro ao dividir por zero só está acontecendo para divisões entre dois inteiros.
    public static double calculaTratandoAExcecao(int num1, double num2){
        try{
            return num1 / num2;
        }catch (RuntimeException e){
            System.out.println("Erro no cálculo: " + e.getMessage());
            e.printStackTrace();
            // Se quiser, ainda é possível lançar uma exceção dentro do catch.
            // throw new IllegalArgumentException("...");
        }
        return 0;
    }

    // Neste caso, por se tratar de RuntimeException, não é obrigatório o throws na assinatura do método.
    public static double calculaSemTratarELancaExcecao(double num1, double num2) throws IllegalArgumentException{
        if(num2 == 0){
            throw new IllegalArgumentException("Erro ao tentar dividir por 0.");
        }
        return num1 / num2;
    }

    public static int calculaSemTratar(int num1, int num2) {
        return num1 / num2;
    }
}
