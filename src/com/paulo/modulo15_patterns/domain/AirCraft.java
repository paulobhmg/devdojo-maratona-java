package com.paulo.modulo15_patterns.domain;

import java.util.HashSet;
import java.util.Set;

public class AirCraft {
    private final String name;
    private final Set<String> availableSeats = new HashSet<>();
    {
        availableSeats.add("A1");
        availableSeats.add("B2");
        availableSeats.add("B3");
    }

    public AirCraft(String name) {
        this.name = name;
    }

    public boolean chooseSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
