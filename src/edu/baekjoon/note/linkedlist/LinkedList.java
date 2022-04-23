package edu.baekjoon.note.linkedlist;

import java.util.Arrays;

public class LinkedList {

    private static int SIZE = 1000005;
    private int[] data = new int[SIZE], prev = new int[SIZE], next = new int[SIZE];
    private static int unused = 1;

    public void init() {
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
    }

    public void traverse() {
        int cur = next[0];
        while (cur != -1) {
            cur = next[cur];
        }
    }

    public void insert(int addr, int num) {
        data[unused] = num;
        prev[unused] = addr;
        next[unused] = next[addr];
        if (next[addr] != -1) {
            prev[next[addr]] = unused;
        }
        next[addr] = unused;
        unused++;
    }

    public void erase(int addr) {
        next[prev[addr]] = next[addr];
        if (next[addr] != -1) {
            prev[next[addr]] = prev[addr];
        }
    }
}
