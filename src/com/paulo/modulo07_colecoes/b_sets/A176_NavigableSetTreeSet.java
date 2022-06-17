package com.paulo.modulo07_colecoes.b_sets;

import com.paulo.modulo07_colecoes.domain.Anime;
import com.paulo.modulo07_colecoes.domain.Smartphone;

import java.util.Comparator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

/* A interface Set provê diretamente as implementações HashSet e LinkedHashSet, que são implementações não ordenadas.
   Além dessas duas, há a implementação SortedSet >> NavigableSet >> TreeSet, que, assim como as implementações anteriores,
   não permitem elementos duplicados. Essa implementação fornece métodos diferentes e específicos para insersão e recuperação
   dos itens da coleção.
   Além disso, como regra, os objetos dessa coleção devem implementar Comparable para que possa ser ordenada ou deve
   receber como argumento em seu construtor um Comparator, para a mesma função.
   Sempre que um item é inserido na coleção, ela será reordenada com base no método compareTo() do objeto ou pelo compare() do comparator.

   ** Diferente das implementaçãos HashSet e LinkedHashSet, um TreeSet quebra o contrato da interface Set em relação aos elementos
      duplicados, pois não utiliza o equals e hashcode para comparar a igualdade entre os objetos, mas sim os métodos
      compareTo() e compare() das interfaces Comparable e Comparator. Sendo assim, ao inserir um novo item, a coleção
      será automaticamente reordenada e um item só será considerado duplicado de acordo com a regra dessas interfaces.  */

class SortSmartphoneByModel implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone sm1, Smartphone sm2){
        return sm1.getModel().compareToIgnoreCase(sm2.getModel());
    }
}

class SortSmartphoneBySerial implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone sm1, Smartphone sm2){
        return sm1.getSerialNumber().compareTo(sm2.getSerialNumber());
    }
}

public class A176_NavigableSetTreeSet {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone("123", "Galaxy S21");
        Smartphone phone2 = new Smartphone("1", "Iphone 12");
        Smartphone phone3 = new Smartphone("12", "Alcatel");
        Smartphone phone4 = new Smartphone("12345", "Moto G20");
        Smartphone phone5 = new Smartphone("1234", "LG K11");

        /* O código abaixo compila, porém gera exceção, pois a classe Smartphone não implementa Comparable, consequentemente
           não possui um método compareTo() para que possa ser ordenada.

          -- NavigableSet<Smartphone> smartphones = new TreeSet<>(List.of(phone1, phone2, phone3, phone4, phone5));
         */

        // Agora, quando passamos um Comparator em seu construtor, a coleção poderá ser ordenada.
        NavigableSet<Smartphone> smartphones = new TreeSet<>(new SortSmartphoneBySerial());
        smartphones.addAll(List.of(phone1, phone2, phone3, phone4, phone5));
        System.out.println(smartphones);
        System.out.println("-----------------------------------------");

        // No exemplo abaixo, não teremos problemas com a criação de uma lista de Animes, pois um anime implementa Comparable.
        Anime shinge = new Anime(10L, "Shingeki no kiogyn", 180);
        Anime dragon = new Anime(3L, "Dragon ball", 300);
        Anime bleach = new Anime(5L, "Bleach", 360);
        Anime bersek = new Anime(9L, "Bersek", 20);
        Anime naruto = new Anime(6L, "Naruto", 1000);
        NavigableSet<Anime> animesComparable = new TreeSet<>(List.of(shinge, dragon, bleach, bersek, naruto));
        System.out.println(animesComparable);
        System.out.println("-----------------------------------------");

        /* Assim como nas listas, quando utilizamos um Comparator para definição de ordenação, ele será priorizado em
           relação ao compareTo() implementado de Comparable() */
        NavigableSet<Anime> animesComparator = new TreeSet<>(new SortById());
        animesComparator.addAll(List.of(shinge, dragon, bleach, bersek, naruto));
        System.out.println(animesComparator);
        System.out.println("-----------------------------------------");
    }
}
