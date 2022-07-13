package com.paulo.modulo15_patterns.domain;

import java.util.HashSet;
import java.util.Set;

/* Quando trabalhamos com Lazy Initialization, a instância não é inicializada antes de tudo, mas sim quando algum local
   fizer a primeira referência a ela no sistema. Dessa forma, sempre que alguém chama o método getInstance(), primeiro é
   feito uma verificação se já existe uma instância criada e caso não exista, cria uma nova e retorna. */
public class AirCraftLazyInitialization {
    private static volatile AirCraftLazyInitialization INSTANCE;
    private final Set<String> availableSeats = new HashSet<>();

    {
        availableSeats.add("A1");
        availableSeats.add("B1");
        availableSeats.add("B3");
    }

    private AirCraftLazyInitialization() { }

    public boolean chooseSeat(String seat) {
        return availableSeats.remove(seat);
    }

    /* Aqui no Lazy Initialization tem um detalhe importante a ser observado. Quando trabalhamos com sistemas multi-threads,
       caso threads diferentes acessem esse método, pode ocorrer de as duas entrarem, verificar se é nulo, passar no teste
       e retornarem duas ou mais instâncias do objeto. Poderíamos retornar isso com o synchronized, porém utilizar o synchronized
       impacta na performance da aplicação. */
    public synchronized AirCraftLazyInitialization getIntanceWithoutCareful() {
        if(INSTANCE == null) {
            INSTANCE = new AirCraftLazyInitialization();
        }
        return INSTANCE;
    }

    /* Para resolver isso, podemos utilizar o double lock, que basicamente, após verificar se o objeto é nulo, faz o lock
       da classe, verificando mais uma vez, garantindo com 99% de chance que não serão retornadas duas instâncias desse objeto. */
    public static AirCraftLazyInitialization getInstance() {
        if(INSTANCE == null) {
            synchronized(AirCraftLazyInitialization.class) {
                if(INSTANCE == null) {
                    INSTANCE = new AirCraftLazyInitialization();
                }
            }
        }
        return INSTANCE;
    }
}
