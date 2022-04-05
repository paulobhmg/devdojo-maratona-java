package com.paulo.modulo03_tratamento_de_erros;

import java.io.FileNotFoundException;
import java.sql.SQLException;

/* É possível capturar mais de uma exceção, adicionando vários blocos CATCH na hierarquia do try, observando algumas regras.
   - Quando temos mais de um catch, caso as exceções sejam da mesma linha de herança, ou seja, da mesma família, a ordem deve
     ser das mais específicas para as mais genéricas, ou seja, primeiro as classes filhas e depois as classes pai.
     Tem que ser assim por que? Por que caso uma exceção mais genérica esteja no topo, ela vai ser capturada e as demais
     serão ignoradas. Sendo assim, ela deve ser a última para que só se chegue nela caso não entre em nenhum outro bloco.

   - Quando as exceções não fazem parte da mesma linha de herança, não tem necessidade de seguir uma ordem específica. */
public class A101_CapturaMultiplasExceptions {
    public static void main(String[] args) {
        // Todas as exceptions tratadas aqui fazem parte da mesma linha de herança. São todas filhas de RuntimeException
        try {
            throw new RuntimeException();
        } catch(IllegalArgumentException e){
            System.out.println("Entrou no IllegalArgumentException.");
        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Entrou no ArrayIndexOutOfBoundsException.");
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Entrou no IndexOutOfBoundsException.");
        } catch(ArithmeticException e){
            System.out.println("Entrou no ArithmeticException.");
        } catch(RuntimeException e){
            System.out.println("Entrou no RuntimeException.");
        }

        try{
            talvezLancaException();
        } catch(FileNotFoundException e){

        } catch(SQLException e){

        }

        /* Para classes que não seguem a mesma hierarquia de herança, e possivel utilizar o Multi-Catch, que basicamente e
           capturar varias exceçoes em um unico bloco Catch. */
        try{
            talvezLancaException();
        } catch(FileNotFoundException | SQLException ignored){

        }
    }

    // Lançando exceções que NÃO são da mesma linha de herança.
    public static void talvezLancaException() throws FileNotFoundException, SQLException {

    }
}
