package edu.baekjoon.problem.deque.p10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final int MINUS_ONE = -1;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int CAPACITY = 10000;
    private static int[] deque = new int[TWO * CAPACITY + ONE];
    private static int head = CAPACITY, tail = CAPACITY;

    private static final String NEW_LINE = "\n";

    private static final String DELIMITERS = " ";
    private static final String PUSH_FRONT = "push_front";
    private static final String PUSH_BACK = "push_back";
    private static final String POP_FRONT = "pop_front";
    private static final String POP_BACK = "pop_back";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        for (int idx = 0; idx < count; idx++) {
            StringTokenizer st = new StringTokenizer(readString(), DELIMITERS);
            String command = st.nextToken();

            switch (command) {
                case PUSH_FRONT:
                    pushFront(readInt(st.nextToken()));
                    break;
                case PUSH_BACK:
                    pushBack(readInt(st.nextToken()));
                    break;
                case POP_FRONT:
                    popFront();
                    break;
                case POP_BACK:
                    popBack();
                    break;
                case SIZE:
                    append(size());
                    break;
                case EMPTY:
                    empty();
                    break;
                case FRONT:
                    front();
                    break;
                case BACK:
                    back();
                    break;
            }
        }
        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void append(int x) {
        sb.append(x).append(NEW_LINE);
    }

    public static void pushFront(int x) {
        deque[head--] = x;
    }

    public static void pushBack(int x) {
        deque[++tail] = x;
    }

    public static void popFront() {
        if (size() == 0) {
            append(MINUS_ONE);
        } else {
            append(deque[++head]);
        }
    }

    public static void popBack() {
        if (size() == 0) {
            append(MINUS_ONE);
        } else {
            append(deque[tail--]);
        }
    }

    public static int size() {
        return tail - head;
    }

    public static void empty() {
        if (size() == 0) {
            append(ONE);
        } else {
            append(ZERO);
        }
    }

    public static void front() {
        if (size() == 0) {
            append(MINUS_ONE);
        } else {
            append(deque[head + 1]);
        }
    }

    public static void back() {
        if (size() == 0) {
            append(MINUS_ONE);
        } else {
            append(deque[tail]);
        }
    }
}
