package com.paulo.modulo03_tratamento_de_erros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/* O try with resources será utilizado para deixar o código mais limpo e tirar a responsabilidade do desenvolvedor de ter
   executar o método close() manualmente. Sendo assim, ao utilizá-lo, podemos instanciar um ou mais objetos no parâmetro da
   cláusula try() e eles serão fechados automaticamente pelo método, mas tem uma regra a ser seguida para este caso:
   - Apenas classes que implementam as interface Closeable ou AutoCloseable poderão ser instanciadas diretamente dessa forma,
     pois o try with resource chama automaticamente o método close() ao final do processo, então, obrigatoriamente as classes
     instanciadas por ele devem implementar essas interfaces. */
public class A103_TryWithResources {
    public static void main(String[] args) {
        trySemWithResources();
        tryWithResources();
    }

    public static void trySemWithResources(){
        Reader reader = null;
        try{
            reader = new BufferedReader(new FileReader("src/com/paulo/modulo03_tratamento_de_erros/domain/arquivo.tsxt"));
            System.out.println("Arquvivo aberto..");
        }catch(IOException e){
            System.out.println("Erro..");
        }finally {
            System.out.println("Arquivo fechado..");
            if(reader != null){
                try{
                    reader.close();
                }catch(IOException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void tryWithResources(){
        try(Reader reader = new BufferedReader(new FileReader("src/com/paulo/modulo03_tratamento_de_erros/domain/arquivo.txt"))){
            System.out.println("arquivo Aberto..");
        }catch(IOException e){
            System.out.println("Error..");
        }
    }
}
