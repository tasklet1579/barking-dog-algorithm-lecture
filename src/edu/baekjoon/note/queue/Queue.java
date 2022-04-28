package edu.baekjoon.note.queue;

public class Queue {

    private final int SIZE = 1000005;
    private int[] data = new int[SIZE];
    private int head = 0, tail = 0;

    public void push(int x) {
        if (head < SIZE) {
            data[tail++] = x;
        }
    }

    public void pop() {
        if (head < SIZE) {
            head++;
        }
    }

    public int front() {
        return data[head];
    }

    public int back() {
        if (tail > 0) {
            return data[tail - 1];
        }
        return -1;
    }
}
