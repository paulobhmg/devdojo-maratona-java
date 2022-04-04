package com.paulo.modulo03_tratamento_de_erros;

import java.io.File;
import java.io.IOException;

/* Diferente das exceções do tipo RuntimeException, essas são filhas diretas da classe Exception. O que isso significa?
   Exceções do tipo Checked devem ser obrigatoriamente tratadas para que o código execute corretamente. Essas exceções
   normalmente ocorrem quando uma ação executada não está sob total controle do desenvolvedor, ou seja, podem haver itens
   externos. Por exemplo, a maior parte dos métodos das classes que trabalham com arquivos tem em sua assinatura o
   throws exception, ou seja, pode ser que ocorra algo que lance uma exceção.

   Sendo assim, é necessário tratar a exceção ou então lançar para que ela seja tratada em um nível acima. De qualquer forma,
   ela deverá ser tratada em algum momento no código, ou poderá ocasionar a parada do programa.

   No exemplo abaixo, tento criar um arquivo. O método createNewFile PODE lançar uma exception do tipo IOException, pois
   pode haver algo, como por exemplo, o arquivo não existir, questões de permissão de acesso, etc. Sendo assim, é obrigatório
   tratar a exceção ou lançar outra, caso contrário o programa nem compila. */
public class A097_CheckedException {
    public static void main(String[] args) {
        File arquivo = new File("src/com/paulo/modulo03_tratamento_de_erros/domain/arquivo.txt");
        try{
            boolean arquivoCriado = arquivo.createNewFile();
            System.out.println("Arquivo criado.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
