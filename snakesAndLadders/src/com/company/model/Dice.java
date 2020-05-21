package com.company.model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int faces;

    public Dice(int faces) {
        this.faces = faces;
    }

    public int rollDice() {
        return ThreadLocalRandom.current().nextInt(1, this.faces + 1);
    }
}
