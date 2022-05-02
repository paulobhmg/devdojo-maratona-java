package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/* Código para introdução às interfaces BasicFileAttributes, DosFileAttributes e PosixFileAttributes.
   Nesta classe, veremos exemplos de como manipular atritubos de arquivos utilizando os pacotes io e nio */
public class A149_RevisaoManipulandoArquivos {
    public static void main(String[] args) throws IOException {
        File file = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/subpasta/OlaMundo.java");
        LocalDateTime date = LocalDateTime.now().minusDays(10);
        boolean isFileCreated = file.createNewFile();

        System.out.println("Arquivo Criado: " + isFileCreated);
        System.out.println(file.getParent());
        boolean isModified = file.setLastModified(date.toInstant(ZoneOffset.UTC).toEpochMilli());

        Path path = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/subpasta/OlaMundo2.java");
        FileTime fileTime = FileTime.from(date.toInstant(ZoneOffset.UTC));
        if(Files.notExists(path)){
            Path isPathCreated = Files.createFile(path);
            System.out.println("Arquivo 2 criado: " + isPathCreated.getFileName());
            Files.setLastModifiedTime(isPathCreated, fileTime);
        }
        if(Files.exists(path)){
            System.out.println("Parent: " + path.getParent());
        }
    }
}
