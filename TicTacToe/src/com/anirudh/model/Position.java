package com.anirudh.model;

public class Position {
    private final Integer row;
    private final Integer col;

    public Position(Integer row, Integer col) {
        this.row = row;
        this.col = col;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }
}
