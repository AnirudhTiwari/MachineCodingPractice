package com.company.model;

public class Ladder {
    private final int start;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    private final int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
