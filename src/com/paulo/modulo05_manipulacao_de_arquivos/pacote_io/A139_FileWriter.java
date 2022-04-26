package com.paulo.modulo05_manipulacao_de_arquivos.pacote_io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/* A classe FileWriter é utilizada para escrever em arquivos. Se o arquivo não existir, cria automaticamente e escreve
   o conteúdo do arquivo no diretório especificado. Caso o diretório especificado não exista, aí sim será lançada uma
   exceção informando que o diretório não existe. */
public class A139_FileWriter {
    public static void main(String[] args) {
        File file = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_io/diretorioa/aula139_filewriter.txt");
        try(FileWriter fw = new FileWriter(file, true)){
            fw.write("\nCabuloso em ação");
            fw.flush();
            System.out.println("Escrita concluída.");
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
