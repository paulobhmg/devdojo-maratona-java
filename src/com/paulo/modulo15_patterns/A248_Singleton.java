package com.paulo.modulo15_patterns;

import com.paulo.modulo15_patterns.domain.AirCraft;
import com.paulo.modulo15_patterns.domain.AirCraftEagerInitialization;
import com.paulo.modulo15_patterns.domain.AirCraftInitializationWithEnum;
import com.paulo.modulo15_patterns.domain.AirCraftLazyInitialization;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* O padrão de projetos Singleton é utilizado quando precisamos garantir que apenas uma instância de um objeto seja
   compartilhado com toda a aplicação, evitando inconsistências e acúmulo de objetos. O exemplo mais prático disso é
   para acesso a bancos de dados, onde todos os usuários devem acessar sempre a mesma conexão, não podendo duplicar
   conexões.

   No exemplo abaixo, o método sellSeat() deve vender o assento de um avião, porém sempre que o método é chamado, está criando
   um novo objeto. Ou seja, dessa forma, a venda da cadeira A1 pode ser vendida para mais de um objeto. Isso está errado, pois
   ela já foi vendida para um objeto. Mas como ao acessar o método novamente, um novo objeto é criado, não só o assento A1,
   estará disponível, mas também todos os outros assentos existentes nesse novo objeto.

   Com o padrão Single, utilizamos um Factory para instanciar um objeto, que poderá ser:
   1 - Eager Initialization | 2 - Lazy Initialization

   As explicações para cada um estará nas classes específicas.
 */
public class A248_Singleton {
    public static void main(String[] args) {
        sellSeat("A1");
        sellSeat("A1");
        sellSeat("B1");
        System.out.println("-----------------------------");

        sellSeatSingletonEager("A1");
        sellSeatSingletonEager("A1");
        sellSeatSingletonEager("B1");
        System.out.println("-----------------------------");

        sellSeatSingletonLazy("A1");
        sellSeatSingletonLazy("A1");
        sellSeatSingletonLazy("B1");
        System.out.println("------------------------------");

        sellSeatSingletonWithEnum("A1");
        sellSeatSingletonWithEnum("A1");
        sellSeatSingletonWithEnum("B1");
    }

    public static void sellSeat(String seat) {
        AirCraft airCraft = new AirCraft("F22");
        System.out.println("AirCraft - " + airCraft + ": " + airCraft.chooseSeat(seat));
    }

    public static void sellSeatSingletonEager (String seat){
        AirCraftEagerInitialization airCraft = AirCraftEagerInitialization.getInstance();
        System.out.println("AirCraftSingletonEager - " + airCraft + ": " + airCraft.chooseSeat(seat));
    }

    /* O Java trabalha um framework chamado Reflections que permite acessar os metadados da classe, fornecendo acesso
       aos atributos e membros da classe mesmo que estejam privados, possibilitando alterar por exemplo um construtor de
       privado para publico. Nessa situação, quando trabalhamos com Lazy Initiation, é possível que através de Reflections,
       seja possível criar uma nova instância de objeto que deveria ser Singleton, isso por que é possível obter um construtor
       dessa classe e instanciar um objeto. */
    public static void sellSeatSingletonLazy (String seat) {
        AirCraftLazyInitialization airCraft = AirCraftLazyInitialization.getInstance();
        System.out.println("AirCraftLazyInitialization - " + airCraft + ": " + airCraft.chooseSeat(seat));

        // Alterando as propriedades do construtor.
        Constructor<AirCraftLazyInitialization> constructor = null;
        try {
            constructor = AirCraftLazyInitialization.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AirCraftLazyInitialization airCraft2 = constructor.newInstance();
            System.out.println("AirCraftLazyInitialization 2 - " + airCraft2 + ": " + airCraft2.chooseSeat(seat));
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* Para resolver a questão exposta acima, podemos utilizar enumerações para criação de objetos singleton.
       Por padrão, enumerações são ThreadSafe, sendo necessário sincronizar apenas o método que remove um item do set.
       Não é possível utilizar o Reflections para alterar o construtor de enumerações, garantindo que o que conseguimos
       fazer no exemplo acima, nunca será possível acontecer no código abaixo. */
    public static void sellSeatSingletonWithEnum (String seat) {
        AirCraftInitializationWithEnum airCraft = AirCraftInitializationWithEnum.INSTANCE;
        System.out.println("AirCraftInitializationWithEnum - " + airCraft.hashCode() + ": " + airCraft.chooseSeat(seat));
    }
}
