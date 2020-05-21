package com.company.model;

import java.util.List;

public class Board {
    public List<Snake> getSnakes() {
        return snakes;
    }

    public List<Ladder> getLadders() {
        return ladders;
    }

    public int getSize() {
        return size;
    }
    private final List<Snake> snakes;
    private final List<Ladder> ladders;

    private final int size;

    public Board(List<Snake> snakes, List<Ladder> ladders, int size) {
        this.snakes = snakes;
        this.ladders = ladders;
        this.size = size;
    }
}
