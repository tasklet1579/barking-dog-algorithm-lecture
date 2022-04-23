package edu.baekjoon.note.stack;

public class Stack {

    private int SIZE = 1000005;
    private int[] data = new int[SIZE];
    private int pos = 0;

    public void push(int x) {
        if (pos < SIZE) {
            data[pos++] = x;
        }
    }

    public void pop() {
        if (pos > 0) {
            pos--;
        }
    }

    public int top() {
        return pos > 0 ? data[pos - 1] : -1;
    }
}
