package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

// Relativizar Paths, significa dizer qual é o caminho relativo deverá ser feito de um Path X para chegar ao Path y.

import java.nio.file.Path;
import java.nio.file.Paths;

public class A148_RelativizandoPaths {
    public static void main(String[] args) {
        Path begin = Paths.get("/home/paulo/documents");
        Path end = Paths.get("/home/paulo/documents/teste/arquivo");

        Path beginToEnd = begin.relativize(end);
        System.out.println(beginToEnd);

        Path endToBegin = end.relativize(begin);
        System.out.println(endToBegin);
        System.out.println("\n----------------------------\n");

        /* Não é possível relativizar um Path absoluto para um Path relativo, pois o java não consegue identificar por conta
           própria qual é a raíz referente à localização de um Path relativo. */

        Path relativeBegin = Paths.get("pasta1/subpasta1/subpasta2");
        Path relativeEnd = Paths.get("subpasta3/arquivo.txt");
        Path relativizedRelative = relativeBegin.relativize(relativeEnd);

        System.out.println(relativizedRelative.getParent());
        System.out.println(relativizedRelative);
        System.out.println("\n----------------------------\n");

        // O código abaixo gera exceção, pois não há como saber de onde o Path é relativo.
        try{
            Path relativeBB = begin.relativize(relativeEnd);
        }catch(IllegalArgumentException e){
            System.out.println("Erro gerado ao tentar relativizar um path absoluto com um path relativo.");
        }
    }
}
