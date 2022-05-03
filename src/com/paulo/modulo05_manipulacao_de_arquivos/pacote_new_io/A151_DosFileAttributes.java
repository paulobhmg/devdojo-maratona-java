package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Caso queira accessar os atributos de files, podemos utilizar o Files.setAttributes. Para sistemas windows, utilizamos
   as classes DosFileAttributes e DosFileAttributesView.
   Como meu sistema operacional é linux, esse exemplo de código fica apenas para conhecimento.  */
public class A151_DosFileAttributes {
    public static void main(String[] args) throws IOException {
        Path fileReadOnly = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/filereadonly.txt");
        if(Files.notExists(fileReadOnly)){
            Path fileCreated = Files.createFile(fileReadOnly);
        }

        Files.setAttribute(fileReadOnly, "dos:hidden", true);
        Files.setAttribute(fileReadOnly, "dos:readonly", true);

        System.out.println("É oculto: " + Files.isHidden(fileReadOnly));
        System.out.println("Pode leitura: " + Files.isReadable(fileReadOnly));
        System.out.println("Pode escrita: " + Files.isWritable(fileReadOnly));
    }
}
