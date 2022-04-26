package com.paulo.modulo05_manipulacao_de_arquivos.pacote_io;

import java.io.File;
import java.io.IOException;

/* A classe File pertence ao pacote Java.io e é utilizada para a criação de arquivos no sistema. Para criar um arquivo
   de fato é necessário utilizar o método createNewFile() do objeto. */

public class A138_File {
    public static void main(String[] args) {
        File file = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_io/diretorio/aula138_file.txt");
        try {
            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /* Como é possível perceber no código acima, ao tentar criar um arquivo que já existe, apenas temos o retorno false,
           não gerando uma exceção ou mensagem de erro. O mesmo acontece quando queremos deletar um arquvio ou acessar
           algum atributo. Para isso, utilizamos os métodos úteis de um objeto File para verificar e manipular arquivos. */

        //Tentando criar um arquivo já existente.
        try {
            if (file.exists()) {
                System.out.println("O arquivo já existe.");
            } else {
                boolean isCreated = file.createNewFile();
                System.out.println("Created: " + isCreated);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("----------------------------");

        // Apagando o arquivo para novo teste.
        boolean isDeleted = file.delete();
        if(isDeleted){
            System.out.println("Arquivo deletado.");
        }else{
            System.out.println("O arquivo não existe para ser deletado.");
        }

        /* Tentando apagar um arquivo que não existe. Nesse caso, como o arquivo não existe, é necessário tratar, pois
           não é gerado exceção ou mensagem informando sua inexistência. */
        isDeleted = file.delete();
        if(isDeleted){
            System.out.println("Arquivo deletado.");
        }else{
            System.out.println("O arquivo não existe para ser deletado.");
        }
        System.out.println("----------------------------");

        // Criando arquivo novamente
        try {
            if (file.exists()) {
                System.out.println("O arquivo já existe.");
            } else {
                boolean isCreated = file.createNewFile();
                System.out.println("Arquivo criado.");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("É diretório: " + file.isDirectory());
        System.out.println("É arquivo: " + file.isFile());
        System.out.println("Está oculto: " + file.isHidden());
        System.out.println("É executável: " + file.canExecute());
        System.out.println("É legível: " + file.canRead());
        System.out.println("Pode escrever: " + file.canWrite());
        System.out.println("Absolute File: " + file.getAbsoluteFile());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Path: " + file.getPath());
        System.out.println("Diretório: " + file.getParent());
        System.out.println("----------------------------");
    }
}
