package edu.baekjoon.problem.deque.p1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITERS = " ";

    private static int CAPACITY = 200;
    private static int[] deque = new int[2 * CAPACITY + 1];
    private static int head = CAPACITY, tail = CAPACITY;

    private static int[] numbers = new int[CAPACITY];

    private static int left, right;

    public static void main(String[] args) throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITERS);
        StringTokenizer loc = new StringTokenizer(readString(), DELIMITERS);
        int size = readInt(info.nextToken());
        int count = readInt(info.nextToken());
        int answer = 0;

        for (int idx = size / 2; idx > 0; idx--) {
            pushFront(idx);
        }

        for (int idx = (int) Math.ceil((double) size / 2 + 0.1); idx <= size; idx++) {
            pushBack(idx);
        }

        for (int idx = 0; idx < count; idx++) {
            numbers[idx] = readInt(loc.nextToken());
        }

        int pick = 0;
        while (pick < count) {
            if (numbers[pick] == front()) {
                popFront();
                pick++;
            } else {
                distance(numbers[pick]);
                if (left <= right) {
                    while (left-- > 0) {
                        pushBack(popFront());
                        answer++;
                    }
                } else {
                    while (right-- >= 0) {
                        pushFront(popBack());
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void pushFront(int x) {
        deque[--head] = x;
    }

    public static void pushBack(int x) {
        deque[tail++] = x;
    }

    public static int popFront() {
        return deque[head++];
    }

    public static int popBack() {
        return deque[--tail];
    }

    public static int front() {
        return deque[head];
    }

    public static void distance(int number) {
        int distance = 0;
        int idx = head;
        while (deque[idx++] != number) {
            distance++;
        }
        left = distance;
        right = tail - head - left - 1;
    }
}
