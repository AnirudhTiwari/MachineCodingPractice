package com.company.model;

public class Player {
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private final int id;
    private final String name;

    public void setPosition(int position) {
        this.position = position;
    }

    private int position;

    public Player(int id, String name, int position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
