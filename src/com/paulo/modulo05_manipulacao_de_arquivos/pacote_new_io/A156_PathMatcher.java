package com.paulo.modulo05_manipulacao_de_arquivos.pacote_new_io;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

/* A classe PathMatcher é utilizada para facilitar a busca por arquivos dentro de um Path específico, a partir da utilização
   de um glob, que especificará qual é a máscara utilizada na busca.

   Esse padrão utiliza o caracter * para ignorar nomes de diretórios ou arquivos, ? para definir quantidades de caracteres.
 */
public class A156_PathMatcher {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/subsubpasta/file.txt");
        Path path2 = Paths.get("pasta/subpasta/subsubpasta/file.bkp");
        Path path3 = Paths.get("Pasta/subpasta/subsubpasta/file.java");

        match(path1, "glob:**.txt"); // ** Ignora os diretórios do Path, antes da extensão do arquivo
        match(path2, "glob:**/*.bkp"); // **/* Ignora os diretórios e o nome dos arquivos, considerando apenas a extesão
        match(path3, "glob:**/file.java"); // **/nomeDoArquivo Ignora o diretório e considera o nome do arquivo específico
        match(path2, "glob:**/file.java"); // Nesse caso vai retornar falso, pois não tem esse arquivo no path2.
        System.out.println("-----------------------------------");

        match(path1, "glob:**/*.???"); // Ignora diretórios e nome do arquivo, priorizando arquivos com 3 letras após o ponto
        match(path3, "glob:**/file.????"); // Ignora os diretórios, considera o nome do arquivo e extensão com 4 letras
        match(path2, "glob:**/file.????"); // Falso, pois nesse diretório não tem arquivos com 4 letras após o ponto
        System.out.println("-----------------------------------");

        match(path1, "glob:**/*.{bkp,txt,java}"); // Considera qualquer tipo de extensão dentro do agrupamento.
        match(path2, "glob:**/*.{???,????}"); // No agrupamento é importante observar que não pode haver espaço após as vírgulas
    }

    public static void match(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println("glob: " + glob + " - " + matcher.matches(path));
    }
}
