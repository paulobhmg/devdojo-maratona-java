package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.nio.file.Path;
import java.nio.file.Paths;

/* Normalizar um Path significa corrigir a árvore de diretórios de acordo com um caminho especificado.
   Neste exemplo, temos uma pasta e uma subpasta que volta duas pastas anteriores à pasta original. Quando instanciamos um
   Path, esse caminho não é normalizado automaticamente, sendo necessário a normalização manual. */
public class A146_NormalizacaoDePaths {
    public static void main(String[] args) {
        Path folder1 = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio");
        Path subFolder1 = Paths.get(folder1.toString(), "..", "..", "normalizacao");

        System.out.println("Original: " + folder1);
        System.out.println("Alterado: " + subFolder1);
        System.out.println("Normalizado: " + subFolder1.normalize());
        System.out.println("---------------------------");

        Path folder2 = Paths.get("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_new_io/diretorio/folder/./subpasta/./subpasta");
        System.out.println("Original: " + folder2);
        System.out.println("Normalizado: " + folder2.normalize());
    }
}
