package com.paulo.modulo05_manipulacao_de_arquivos.pacote_io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* A classe FileReader é utilizada para leitura de arquivos. Diferente da classe FileWriter, caso o arquivo não exista é
   gerado uma exceção informando que o arquivo ou diretório não foi encontrado.

   A leitura de arquivos é feita basicamente de duas maneiras:
     1 - O método read(), posiciona um cursor na posição da primeira letra do arquivo, que será representada pelo seu valor
         na tabela ASCII e caso a posição do cursor não retorne nenhum valor, será retornado -1. Sendo assim, para leitura
         nesse modelo, percorre-se o arquivo inteiro até que o valor encontrado pelo cursor seja -1.

     2 - Deve-se criar um array de caracteres, que severá ser passado como parâmetro para o método read(). Dessa forma,
         o método irá jogar o todas as letras do arquivo dentro do array, que deverá ser percorrido depois. */
public class A140_FileReader {
    public static void main(String[] args) {
        File file = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_io/diretorio/aula140_filereader.txt");

        //Fazendo a leitura do arquivo através do método read() sem parâmetros.
        try(FileReader fr = new FileReader(file)){
            int i;
            while((i = fr.read()) != -1){
                System.out.print((char) i);
            }
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("\n------------------------------------\n");

        // Fazendo a leitura do arquivo através passando um buffer de char no parâmetro do read().
        try(FileReader fr = new FileReader(file)){
            char[] letras = new char[1000];
            int size = fr.read(letras); // Retorna a quantidade de caracteres lidos.
            for(int i = 0; i< size; i++){
                System.out.print(letras[i]);
            }
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
