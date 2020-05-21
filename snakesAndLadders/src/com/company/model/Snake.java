package com.company.model;

public class Snake {
    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    private final int head;
    private final int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}
