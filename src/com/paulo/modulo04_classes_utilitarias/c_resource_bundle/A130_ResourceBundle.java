package com.paulo.modulo04_classes_utilitarias.c_resource_bundle;

/* Um arquivo ResourceBundle permite a internacionalização dos sistemas, a partir da padronização de mensagens e labels,
   realizados através de arquivos .properties, que armazenam os valores para as mensagens, de acordo com a localização.

   * Os arquivos devem ser criados na pasta SRC do projeto.
   * A nomenclatura para os arquivos segue o padrão: nomedoarquivo_lingua_PAIS (mensagens_pt_BR, mensagens_en_US).
   * As mensagens são indexadas ao arquivo, no modelo Chave => Valor.
   * As mensagens são recuperadas a partir de qualquer classe do sistema, através de objetos do tipo ResourceBundle, que
     fazem referência a um arquivo do tipo properties e fornece métodos para recuperação dos valores contindos em cada chave. */

import java.util.Locale;
import java.util.ResourceBundle;

public class A130_ResourceBundle {
    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("mensagens", new Locale("pt", "BR"));
        System.out.println(resource.getString("bomDia"));
        System.out.println(resource.getString("boaNoite"));
        System.out.println("------------");

        resource = ResourceBundle.getBundle("mensagens", new Locale("en", "US"));
        System.out.println(resource.getString("bomDia"));
        System.out.println(resource.getString("boaNoite"));
        System.out.println("------------");

        /* Alem dos arquivos de localizaçao especificos, e possivel criar um arquivo generico, que armazenara as mensagens
           que deverao ser utilizadas como padrao nos casos em que nao exista um arquivo definido para a localizaçao
           de um ResourceBundle. */
        resource = ResourceBundle.getBundle("mensagens", new Locale("it", "IT"));
        System.out.println(resource.getString("bomDia"));
        System.out.println(resource.getString("boaNoite"));
        System.out.println("------------");

        /* Por padrão, quando utilizamos ResourceBundle, o Java faz o seguinte:
         1 - Procura pelo arquivo referente à localização do ResourceBundle (mensagens_it_IT);
         2 - Procura pelo arquivo que possui a linguagem do ResourceBundle (mensagens_it);
         3 - Procura pelo arquivo que possui a Localização default do sistema operacional (mensagens_en_US);
         4 - Procura pelo arquivo que possui a linguagem default do sistema operacional (mensagens_en);
         5 - Procura pelo arquivo que possui apenas o nome (mensagens) */
    }
}
