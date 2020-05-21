package com.anirudh.model;

public class Grid {
    public int getSize() {
        return size;
    }

    private final int size;
    private final Shape[][] grid;

    public Shape getBlankCell() {
        return blankCell;
    }

    private final Shape blankCell;

    public Grid(int size) {
        this.size = size;
        this.grid = new Shape[size][size];
        this.blankCell = new Shape(".");
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                grid[i][j] = this.blankCell;
            }
        }
    }

    public Shape[][] getGrid() {
        return grid;
    }
}
