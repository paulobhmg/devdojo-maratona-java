package com.paulo.modulo03_tratamento_de_erros;

/* Quando falamos de possíveis erros no sistema, devemos entender que existe a seguinte hierarquia.
 1 - Classe Trowable: Basicamente a classe pai
 2.1 - Error: Filha de Trowable
 2.2 - Exception: Filha de Trowable

 Quando acontecem erros, normalmente não há nada que possa ser feito. Erros normalmente fazem com que seja necessário
 parar a execução do programa até que o problema seja corrigido. Exemplos de erro são OutOfMemoryError ou StackOverFlowError.
 Em ambos os casos, o sistema para, pois não há o que possa ser feito.

 Neste exemplo, vamos simular um programa que chama um método recursivo infinitas vezes até que o espaço em memória
 reservado para a Stack do java seja estourado, ocasionando a parada do sistema. */
public class A095_Error {
    public static void main(String[] args) {
        recursivo();
    }

    public static void recursivo(){
        recursivo();
    }
}
