package com.anirudh.model;

public class Player {
    private final int id;
    private final String name;
    private final Shape shape;

    public Player(int id, final String name, Shape shape) {
        this.id = id;
        this.name = name;
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
    }

    public String getName() {
        return name;
    }
}
