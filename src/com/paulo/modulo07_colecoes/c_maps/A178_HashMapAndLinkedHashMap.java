package com.paulo.modulo07_colecoes.c_maps;

import java.util.*;

/* A interface Map é um tipo de coleção de dados, porém não faz parte da família Collection.
   Um map é uma coleção associativa de chave => valor, ou seja, cada chave terá um valor associado a ela.
   Assim como um Set, um Map não pode ser ordenado. A organização dos seus itens é a partir do hashcode, já que as chaves em
   um Map é basicamente um conjunto Set.  */
public class A178_HashMapAndLinkedHashMap {
    public static void main(String[] args) {
        Map<String, String> stringMap = new HashMap<>();
        stringMap.put("teklado", "teclado");
        stringMap.put("mouze", "mouse");
        stringMap.put("munitor", "monitor");
        stringMap.put("foni", "fone");

        System.out.println(stringMap);
        System.out.println("-------------------");

        // Ao ler uma estrutura de Map, quando recuperamos as chaves, temos um Set como retorno.
        Set<String> chaves = stringMap.keySet();
        System.out.println("Chaves: " + chaves);

        // Assim, quando recuperamos os valores das chaves, temos uma Collection como retorno.
        List<String> valores = new ArrayList<>(stringMap.values());
        System.out.println("Valores: " + valores);

        /* Por que essa diferença? Um map é uma estrutura associativa que não permite CHAVES duplicadas, porém podemos
           ter chaves com nomes diferentes, mas com um valor já existente. O que define a duplicidade em um Map é a chave. */
        System.out.println("--------------------------------------------");

        /* O método get() de um map recebe como parâmetro um objeto do mesmo tipo que foi definido como chave para um Map.
           Sendo assim, quando percorremos um Map, podemos utilizar a chave como parâmetro para o loop e a cada iteração
           chamar o método get(), que irá receber como argumento a chave que está sendo iterada, logo, recuperará o valor associado àquela chave. */
        System.out.println("Percorrendo Map baseado nas chaves:");
        for(String chave : stringMap.keySet()){
            System.out.printf("%s - %s\n", chave, stringMap.get(chave));
        }
        System.out.println("---------------------------");

        /* Outra forma de percorrer um  Map é utilizando o objeto Map.Entry<k,v>, que basicamente armazena a chave e valor de um Map.
           Dessa forma, percorremos um novo Set, que dará acesso à chave e valor simultâneamente. */
        System.out.println("Percorrendo Map utilizando o objeto Map.Entry: ");
        for(Map.Entry<String, String> item : stringMap.entrySet()){
            System.out.printf("%s - %s\n", item.getKey(), item.getValue());
        }
        System.out.println("---------------------------");

        // Um linkedHashMap funciona de forma similar ao HashMap, com a diferença que mantém a ordem de insersão dos dados.
        stringMap = new LinkedHashMap<>();
        stringMap.put("teklado", "teclado");
        stringMap.put("mouze", "mouse");
        stringMap.put("munitor", "monitor");
        stringMap.put("foni", "fone");

        System.out.println("LinkedHashMap: " + stringMap);

        /* Testando a não duplicidade em um Map.
           Ao ler os codigos abaixo podemos perceber que uma chave duplicada nao e inserida. Mas neste caso, caso a chave
           ja exista, o seu valor sera sobrescrito. Ja no segundo exemplo, utilizamos uma chave de nome diferente, mas com
           um valor existente e sera adicionado normalmente. Com isso e possivel perceber que o que e levado em consideraçao
           em relaçao a duplicidade eh a chave, nao o valor. */
        stringMap.put("teklado", "tecladooo");
        System.out.println("Tenta inserir chave duplicada (fail - valor sobrescrito): " + stringMap);

        stringMap.put("tekklado", "teclado");
        System.out.println("Tenta inserir valor duplicado (ok): " + stringMap);

        /* Caso uma chave ja exista e nao pode ter seu valor sobrescrito, utilizamos o metodo putIfAbsent(), que ira
           verificar se a chave existe antes de executar o metodo put(), que sobrescreveria o valor. */
        stringMap.putIfAbsent("tekklado", "tecladooooo");
        System.out.println("Tenta iserir nova chave (fail - nao sobrescreve conteudo): " + stringMap);

    }
}
