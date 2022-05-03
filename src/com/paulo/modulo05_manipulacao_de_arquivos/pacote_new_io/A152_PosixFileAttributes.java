package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class A152_PosixFileAttributes {
    public static void main(String[] args) throws IOException {
        Path readOnly = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/filereadyonly.txt");
        if(Files.notExists(readOnly)) Files.createFile(readOnly);

        PosixFileAttributes pf = Files.readAttributes(readOnly, PosixFileAttributes.class);
        System.out.println("Permissões padrão: " + pf.permissions());
        System.out.println("________________________________\n");

        PosixFileAttributeView fw = Files.getFileAttributeView(readOnly, PosixFileAttributeView.class);
        Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rw-rw-r--");
        fw.setPermissions(posixFilePermissions);

        System.out.println("Permissões alteradas: " + fw.readAttributes().permissions());
    }
}
