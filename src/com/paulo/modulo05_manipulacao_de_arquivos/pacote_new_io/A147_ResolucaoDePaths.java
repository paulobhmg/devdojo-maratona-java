package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/* Resolver um Path significa mesclar dois Paths distintos, a fim de criar um único Path.
   Neste caso, devem ser feitas algumas observações:
   1 - Um Path absoluto poderá ser resolvido com um Path relativo, tornando-se um só.
   2 - Um Path relativo poderá ser resolvido com outro Path relativo, tornando-se um só.
   3 - Um Path relativo NÃO poderá ser resolvido com um Path absoluto. Neste caso, o Path absoluto será retornado, pois
       como ele já é absoluto, não há o que resolver.
   4 - É necessário se atentar para Paths que referenciam arquivos, pois eles podem ser resolvidos com Paths relativos,
       o que poderá ocasionar erros caso tente criar um diretório a partir dessa resolução, pois como não são diretórios,
       poderá ocorrer exceções de diretório não encontrado. */
public class A147_ResolucaoDePaths {
    public static void main(String[] args) {
        Path absolute = Paths.get("/home/ubuntu/Documents/java");
        Path relative = Paths.get("devdojo/maratona");
        File file = new File("arquivo.txt");

        System.out.println("Absoluto: " + absolute);
        System.out.println("Relativo: " + relative);
        System.out.println("Arquivo: " + file);
        System.out.println("------------------------");

        System.out.println("Absolute + relative: " + absolute.resolve(relative));
        System.out.println("Absolute + file: " + absolute.resolve(file.toPath()));
        System.out.println("Absolute + relative + file: " + absolute.resolve(relative).resolve(file.toPath()));
        System.out.println("------------------------");

        System.out.println("relative + file: " + relative.resolve(file.toPath()));
        System.out.println("file + relative: " + file.toPath().resolve(relative)); // Notar que é resolvido, porém se for criar arquivo não dará certo.

        // Notar que relativo não resolve com absoluto, prevalecendo sempre o absoluto.
        System.out.println("relative + absolute (not work): " + relative.resolve(absolute));
        System.out.println("file + absolute (not work): " + file.toPath().resolve(absolute));
    }
}
