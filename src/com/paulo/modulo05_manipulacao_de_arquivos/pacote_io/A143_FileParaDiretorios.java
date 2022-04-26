package com.paulo.modulo05_manipulacao_de_arquivos.pacote_io;

import java.io.File;
import java.io.IOException;

/* A classe File manipula não apenas arquivos, mas também diretórios.
   - Assim como na criação de um arquivo, um diretório será criado caso não exista e se existir, retornará falso.
   - O método mkdir() irá criar um diretório. Caso queira criar um arquivo, deve ser utilizado o createNewFile().
     Caso utilize o mkdir() para criar um arquivo, mesmo possuindo a extensão .txt, será criado um diretório e ao tentar
     criar um arquivo da forma correta, não será criado, pois já haverá um diretório criado com o nome desejado para o arquivo.
 */
public class A143_FileParaDiretorios {
    public static void main(String[] args) throws IOException {
        File directory = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_io/diretorio/folder");
        boolean isDirectoryCreated = directory.mkdir();
        System.out.println("Diretório criado: " + isDirectoryCreated);

        // É possível criar um arquivo a partir da referência de um diretório.
        File file = new File(directory, "aula143_file.txt");
        // file.mkdir(); -- Notar que o método mkdir() cria um diretório, ou seja, ignora a extensão .txt
        boolean isFileCreated = file.createNewFile();
        System.out.println("Arquivo criado: " + isFileCreated);
        System.out.println("-------------------------------");

        // Para renomear um arquivo, é importante entender que ele deverá ser renomeado a partir da mesma referência do seu diretório
        File newFileName = new File(directory, "arquivo-renomeado.txt");
        boolean isFileRenamed = file.renameTo(newFileName);
        System.out.println("Arquivo renomeado: " + isFileRenamed);

        File newDirectoryName = new File(directory.getParent() + "/new_directory_name");
        boolean isDirectoryRenamed = directory.renameTo(newDirectoryName);
        System.out.println("Diretório renomeado: " + isDirectoryRenamed);
    }
}
