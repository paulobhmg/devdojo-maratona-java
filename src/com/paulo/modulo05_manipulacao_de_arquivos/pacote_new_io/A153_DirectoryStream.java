package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* A classe DirectoryStream<T> trabalha com o Generics e é utilizada basicamente para listar arquivos de um diretório, de
   forma similar ao DIR do Windows e o LS do Linux. Essa classe não permite muita dinâmica, ou seja, não lista arquivos
   em subdiretórios, exibindo apenas uma lista de um diretório específico.

   Um DirectoryStream cria um stream de dados de um diretório. No caso de um DirectoryStream<Path>, cada item dentro desse
   diretório será convertido em um Path, obtendo assim uma lista de Paths.
*/
public class A153_DirectoryStream {

    public static void main(String[] args) {
        Path directory = Paths.get("src/com/paulo");
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(directory)){
            for(Path path : stream) {
                System.out.println(path.getFileName());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
