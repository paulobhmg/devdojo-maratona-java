package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* A classe ZipOutputStrem é utilizada para criar arquivos zipados.
   Para isso é necessário criar um Objeto do tipo ZipOutputStream e DirectoryStream, sendo que o DirectoryStream é o diretório
   de onde os arquivos serão buscados, enquanto o ZipOutputStream é o diretório que será zipado.

   Dentro do laço do DirectoryStream é necessário instanciar um ZipEntry que basicamente cria dentro do ZipOutputStream os arquivos
   com o mesmo nome. Porém, quando fazemos isso, apenas os nomes dos arquivos são criados. Para copiar o conteúdo utilizamos o Files.copy, que pegará
   o conteúdo do arquivo e adicionará dentro do ZipOutputStream, para cada entrada.
   */
public class A158_ZipOutputStream {
    public static void main(String[] args) {
        Path zipedFiles = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/subpasta/subsubpasta/files.zip");
        Path filesToZip = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/subpasta/subpasta");
        zip(zipedFiles, filesToZip);
    }

    public static void zip(Path pathToZip, Path filesToZip){
        try(ZipOutputStream zipper = new ZipOutputStream(Files.newOutputStream(pathToZip)); // Instancia um fluxo para transformação dos arquivos.
            DirectoryStream<Path> stream = Files.newDirectoryStream(filesToZip)){ // Instancia um fluxo para leitura dos arquivos do diretório source
            for(Path path : stream){
                ZipEntry entry = new ZipEntry(path.getFileName().toString()); // Cria uma nova entrada para o zip, com o nome do arquivo
                zipper.putNextEntry(entry); // Insere no zipper a entrada.
                Files.copy(path, zipper); // Copia o conteúdo do arquivo para a entrada
                zipper.closeEntry(); //Fecha o fluxo.
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
