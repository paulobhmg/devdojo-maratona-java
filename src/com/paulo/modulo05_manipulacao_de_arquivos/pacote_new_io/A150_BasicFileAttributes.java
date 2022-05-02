package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/* BasicFileAttributes é a interface mais genérica para se trabalhar com arquivos de acordo com o tipo de sistema operacional
   que esta utilizando a aplicaçao. Sendo assim, essa interface retornara um objeto diferente para cada sistema operacional
   utilizado.

   Existem as classes BasicFileAttributes, DosFileAttributes e PosixFileAttributes, que sao utilizadas apenas para leitura
   dos atributos de arquivos e diretorios.

   Para manipular os atributos, utilizamos as classes BasicFileAttributesView, DosFileAttributesView e PosixFileAttributesView. */
public class A150_BasicFileAttributes {
    public static void main(String[] args) throws IOException {
        Path file = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/file.txt");
        BasicFileAttributes bf = null;
        Path file1 = null;

        if(Files.exists(file)) {
            System.out.println("arquivo já existe.");
            bf = Files.readAttributes(file, BasicFileAttributes.class);
        }else {
            file1 = Files.createFile(file);
            bf = Files.readAttributes(file1, BasicFileAttributes.class);
        }
        System.out.println("File key: " + bf.fileKey());
        System.out.println("Is regular file: " + bf.isRegularFile());
        System.out.println("Is directory: " + bf.isDirectory());
        System.out.println("Is other: " + bf.isOther());
        System.out.println("Creation time: " + bf.creationTime());
        System.out.println("Last access time: " + bf.lastAccessTime());
        System.out.println("Last modified time: " + bf.lastModifiedTime());
        System.out.println("-------------------------");

        FileTime creationTime = bf.creationTime();
        FileTime lastModifiedTime = FileTime.from(LocalDateTime.now().minusDays(10).toInstant(ZoneOffset.UTC));
        FileTime lastAccessTime = FileTime.fromMillis(System.currentTimeMillis());
        BasicFileAttributeView fw = Files.getFileAttributeView(file, BasicFileAttributeView.class);

        fw.setTimes(lastModifiedTime, lastAccessTime, creationTime);

        FileTime newCreationTime = fw.readAttributes().creationTime();
        FileTime newLastModified = fw.readAttributes().lastModifiedTime();
        FileTime newLastAccess = fw.readAttributes().lastAccessTime();

        System.out.println(newCreationTime);
        System.out.println(newLastModified);
        System.out.println(newLastAccess);
    }
}
