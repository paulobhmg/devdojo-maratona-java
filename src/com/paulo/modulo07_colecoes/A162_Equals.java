package com.paulo.modulo07_colecoes;

import com.paulo.modulo07_colecoes.domain.Smartphone;

/* Por padrão, todos os objetos extendem a classe Object e por consequência, os métodos equals e hashcode.
   O método equals() é utilizado para comparar se dois objetos são iguais, porém, a comparação feita pela classe Object
   verifica apenas se dois objetos fazem referência ao mesmo espaço e memória. Portanto, o método deve ser sobrescrito
   em qualquer objeto, afim de definir como será tratado a igualdade entre dois objetos.

   Já o método HashCode é utilizado para Hash tables. Um hashcode basicamente é um código criado com base no conteúdo
   dos campos definidos para o hash que serão utilizados para identificar um objeto.
   Vários objetos podem possuir o mesmo valor Hash gerado. Quando isso ocorre, o java utiliza o equals para distinguir
   os objetos com base na lógica criada para definição de igualdade.

   Quando trabalhamos com coleções de dados, distinguir um objeto do outro é importante para ordenação dos dados e performance.
   O HashCode é utilizado em tabelas de alta performance, onde a busca é feita diretamente pelo código Hash de um objeto.
   Quanto mais específico é um código Hash, maior a parformance da busca ou ordenação de uma Coleção.
 */
public class A162_Equals {
    public static void main(String[] args) {
        Smartphone smart1 = new Smartphone("12345", "Alcatel");
        Smartphone smart2 = new Smartphone(null, "Alcatel");
        Smartphone smart3 = new Smartphone("12345", "Samsung");
        Smartphone smart4 = new Smartphone("1234", "Samsung");

        System.out.println(smart1.equals(smart2));
        System.out.println(smart1.equals(smart3));
        System.out.println(smart1.equals(smart4));
    }
}
