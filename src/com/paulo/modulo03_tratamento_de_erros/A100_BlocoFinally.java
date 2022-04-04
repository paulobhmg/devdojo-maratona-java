package com.paulo.modulo03_tratamento_de_erros;

/* O bloco finally é utilizado para executar uma ação, independente de ter capturado ou não uma exceção. Um exemplo  disso
   é quando estamos escrevendo em um arquivo, onde há o momento da abertura, escrita e fechamento. Como exemplo:

   Em um fluxo perfeito, abre o arquivo, escreve e finalmente fecha.
   Em um fluxo de erros, abre o arquivo e tenta escrever. Aconteceu algo? Executa o bloco catch e finalmente fecha.

   Basicamente é isso que deve ser feito em um bloco finally, que será utilizado bastante futuramente. A princípio,
   basta saber disso. */
public class A100_BlocoFinally {
    public static void main(String[] args) {
        fluxoPerfeito();
        fluxoImperfeito();
    }

    public static void fluxoPerfeito(){
        try{
            System.out.println("Abrindo arquivo...");
            System.out.println("Escreve no arquivo...");
            System.out.println("Finalização da escrita...");
        }catch(RuntimeException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            System.out.println("Fecha arquivo.");
        }
    }

    public static void fluxoImperfeito(){
        try{
            System.out.println("Abrindo arquivo...");
            System.out.println("Escrevendo no arquivo...");
            throw new RuntimeException("Aconteceu algo inesperado ao escrever no arquivo.");
        }catch(RuntimeException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            System.out.println("Fechando arquivo.");
        }
    }
}
