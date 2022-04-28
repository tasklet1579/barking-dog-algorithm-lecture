package edu.baekjoon.problem.queue.p10845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITERS = " ";
    private static final String NEW_LINE = "\n";
    
    private static final int CAPACITY = 10000;
    private static int[] queue = new int[CAPACITY];
    private static int head = 0, tail = 0;
    
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";
    private static final int ONE = 1;
    private static final int ZERO = 0;
    private static final int MINUS_ONE = -1;

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        for (int idx = 0; idx < count; idx++) {
            String commandLine = readString();
            StringTokenizer st = new StringTokenizer(commandLine, DELIMITERS);
            String command = st.nextToken();

            switch (command) {
                case PUSH:
                    push(readInt(st.nextToken()));
                    break;
                case POP:
                    pop();
                    break;
                case SIZE:
                    size();
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

    public static void push(int x) {
        queue[tail++] = x;
    }

    public static void pop() {
        if (head == tail) {
            append(MINUS_ONE);
        } else {
            append(queue[head++]);
        }
    }

    public static void size() {
        append(tail - head);
    }

    public static void empty() {
        if (head == tail) {
            append(ONE);
        } else {
            append(ZERO);
        }
    }

    public static void front() {
        if (head == tail) {
            append(MINUS_ONE);
        } else {
            append(queue[head]);
        }
    }

    public static void back() {
        if (head == tail) {
            append(MINUS_ONE);
        } else {
            append(queue[tail - 1]);
        }
    }
}
