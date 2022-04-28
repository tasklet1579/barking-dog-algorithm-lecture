package edu.baekjoon.note.deque;

public class Deque {

    private final int SIZE = 1000005;
    private int[] data = new int[2 * SIZE + 1];
    private int head = SIZE, tail = SIZE;

    void push_front(int x) {
        data[--head] = x;
    }

    void push_back(int x) {
        data[tail++] = x;
    }

    void pop_front() {
        head++;
    }

    void pop_back() {
        --tail;
    }

    int front() {
        return data[head];
    }

    int back() {
        return data[tail - 1];
    }
}
