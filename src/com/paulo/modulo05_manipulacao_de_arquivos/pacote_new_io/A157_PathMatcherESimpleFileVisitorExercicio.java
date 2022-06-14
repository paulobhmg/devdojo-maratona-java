package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class Simple extends SimpleFileVisitor<Path>{
    private PathMatcher matcher;

    public Simple(String matcher){
        this.matcher = FileSystems.getDefault().getPathMatcher(matcher);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
       if(matcher.matches(file)) {
            System.out.println(file.getFileName());
       }
       return FileVisitResult.CONTINUE;
    }
}
public class A157_PathMatcherESimpleFileVisitorExercicio {
    public static void main(String[] args) {
        Path root = Paths.get(".");
        try {
            Files.walkFileTree(root, new Simple("glob:**/*.java"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
