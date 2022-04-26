package com.paulo.modulo05_manipulacao_de_arquivos.pacote_io;

import java.io.*;

/* As classes BurreferedWriter e BufferedReader encapsulam as classes FileWriter e FileReader. São classes melhoradas,
   que utilizam buffer em memória para trabalhar com arquivos, melhorando a performance, através da liberação dos recursos
   da máquina.

   - Aqui, BufferedWriter, diferente de FileWriter, permite ainda adicionar um newLine().
   - Já para BufferedReader, diferente de FileReader, faz a leitura de uma linha inteira e quando chega ao final do arquivo
     retorna null, não -1. */
public class A142_BufferedWriterEBufferedReader {
    public static void main(String[] args) {
        File file = new File("src/com/paulo/modulo05_manipulacao_de_arquivos/pacote_io/diretorio/aula142_buffered.txt");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write("Cabulosamente aprendendo a escrever em arquivos.");
            bw.newLine();
            bw.flush();
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }

        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String linha;
            while((linha = bf.readLine()) != null){
                System.out.println(linha);
            }
        }catch(IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
