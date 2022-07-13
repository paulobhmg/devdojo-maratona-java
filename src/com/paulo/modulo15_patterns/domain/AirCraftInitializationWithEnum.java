package com.paulo.modulo15_patterns.domain;

import java.util.HashSet;
import java.util.Set;

public enum AirCraftInitializationWithEnum {
    INSTANCE;

    private final Set<String> availableSeats;

    AirCraftInitializationWithEnum() {
        availableSeats = new HashSet<>();
        availableSeats.add("A1");
        availableSeats.add("A2");
        availableSeats.add("B1");
    }

    public boolean chooseSeat(String seat) {
        return availableSeats.remove(seat);
    }
}
