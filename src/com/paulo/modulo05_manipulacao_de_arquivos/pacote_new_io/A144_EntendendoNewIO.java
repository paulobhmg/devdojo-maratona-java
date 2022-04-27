package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* O pacote nio introduziu classes e interfaces úteis para manipulação de arquivos e diretórios do sistema.
   Esse pacote conta basicamente com a interface Path e as classes Paths e Files.

   Um diretório ou arquivo é criado a partir da interface Path e instanciado a partir da classe Paths.
   Já para a manipulação de um arquivo, utilizamos a classe Files.

   Ao instanciar um objeto do tipo Path, não estamos criando um arquivo ou diretório em si, mas apenas fazendo uma
   referência para o local onde será criado o arquivo. */
public class A144_EntendendoNewIO {
    public static void main(String[] args) {
        Path p1 = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder");
        Path p2 = Paths.get("src/com", "paulo", "modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder");
        Path p3 = Paths.get("src", "paulo", "modulo05_manipulacao_de_arquivos", "pacote_new_io", "diretorio", "folder");

        System.out.printf("%s, %s  %s\n", p1.getFileName(), p2.getFileName(), p3.getFileName());
        System.out.println("---------------------");

        /* Para instanciar um arquivo ou diretório, utilizamos a classe Files. Para criar um diretório, utilizamos os
           métodos createDirectory() ou createDirectories(). A diferença entre os dois é a seguinte:
           - No primeiro, caso o diretório já exista, é lançado uma exceção. Caso tente criar uma cadeia de diretórios,
             caso um diretório pai não exista, também lançará uma exceção.
           - No segundo, caso o diretório já exista, não lança exeção. Caso tente criar uma cadeia de diretórios e o
             diretório pai não exista, cria todos os diretórios necessários, em cadeia. */

        // Criando um diretório (Verifica primeiro se o diretório já existe, para evitar exceções)
        if(Files.notExists(p1)){
            try {
                Files.createDirectory(p1);
            } catch (IOException e) {
                System.out.println("Erro: " + e.getMessage());;
            }
        }else{
            System.out.println("Diretório já existe.");
        }
        System.out.println("---------------------");


        // Cria diretórios encadeados (Verifica se já existe para exibir mensagem, pois caso exista, não cria e não lança exceção)
        Path subsubPasta = Paths.get(p1.toString(), "subpasta", "subpasta");
        if(Files.notExists(subsubPasta)){
            try {
                Path arquivoCriado = Files.createDirectories(subsubPasta);
                System.out.println("Pasta criada: " + arquivoCriado.getFileName());
            } catch(IOException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }else{
            System.out.println("Diretorio ja existe.");
        }


        // Cria um arquivo - Verifica se já existe um diretório para salvar o arquivo
        Path file = Paths.get(subsubPasta.toString(), "file.txt");
        if(Files.exists(subsubPasta)){
            // Verifica a existência do arquivo, pois se já existir, lança exceção.
            if(Files.notExists(file)) {
                try {
                    Path arquivoCriado = Files.createFile(file);
                    System.out.println("Arquivo criado em " + arquivoCriado);
                } catch (IOException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
            } else {
                System.out.println("Arquivo já existe.");
            }
        }
        System.out.println("---------------------");


        Path source = Paths.get(file.toString());
        Path target = Paths.get(file.getParent().toString(), "renamed.txt");

        // Renomeando um arquivo (necessário utilizar o diretório pai para referência do local do novo arquivo)
        try {
            Path renamedFile = Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File renamed: " + renamedFile.getFileName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
