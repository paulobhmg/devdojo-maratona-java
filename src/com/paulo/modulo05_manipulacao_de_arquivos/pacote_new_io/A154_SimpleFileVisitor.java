package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

/* A classe SimpleFileVisitor permite percorrer listar diretórios e subdiretórios */

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class Visit extends SimpleFileVisitor<Path> {
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        String fileName = file.getFileName().toString();
        if(fileName.endsWith(".java") || fileName.substring(fileName.lastIndexOf(".") + 1).equals("java")){
            System.out.println(fileName);
        }
        return FileVisitResult.CONTINUE;
    }
}

public class A154_SimpleFileVisitor {
    public static void main(String[] args) {
        Path root = Paths.get(".");
        try{
            Files.walkFileTree(root, new Visit());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
