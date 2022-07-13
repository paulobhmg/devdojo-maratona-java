package com.paulo.modulo15_patterns.domain;

import java.util.HashSet;
import java.util.Set;

/* Dizemos que a classe tem inicialização Eager, quando o atributo dessa classe é estático e inicializado em sua definiçã.
   Pelo fato do atributo ser estático e final, ele será inicializado no momento em que o ClassLoader inicializar a classe.
   Dessa forma, uma instância do objeto sempre estará disponível antes mesmo dos outros objetos o acessarem no sistema.

   Neste caso, o construtor desse tipo de classe deve ser privado, a fim de evitar que um objeto seja instanciado
   manualmente, sendo necessário um método getInstance(), que retornará uma instância do objeto já disponível em memória.
   sendo assim, sempre que um objeto externo pega uma nova instância, estará sempre se referenciando à mesma instância. */
public final class AirCraftEagerInitialization {
    private static final AirCraftEagerInitialization INSTANCE = new AirCraftEagerInitialization();
    private final Set<String> availableSeats = new HashSet<>();

    {
        availableSeats.add("A1");
        availableSeats.add("B1");
        availableSeats.add("B3");
    }

    private AirCraftEagerInitialization() {}

    public static AirCraftEagerInitialization getInstance() {
        return INSTANCE;
    }

    public boolean chooseSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
