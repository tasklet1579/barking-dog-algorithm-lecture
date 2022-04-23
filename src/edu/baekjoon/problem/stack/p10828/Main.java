package edu.baekjoon.problem.stack.p10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static final int CAPACITY = 10000;
    private static int[] stack = new int[CAPACITY];
    private static int pointer = 0;
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String TOP = "top";

    public static void main(String[] args) throws IOException {
        int commandCount = readInt(readString());

        for (int c = 0; c < commandCount; c++) {
            String command = readString();

            if (command.startsWith(PUSH)) {
                StringTokenizer st = new StringTokenizer(command, DELIMITER);
                st.nextToken();
                push(readInt(st.nextToken()));
            } else if (command.startsWith(POP)) {
                append(pop());
            } else if (command.startsWith(SIZE)) {
                append(size());
            } else if (command.startsWith(EMPTY)) {
                append(empty());
            } else if (command.startsWith(TOP)) {
                append(top());
            }
        }
        System.out.println(sb);
    }

    public static void push(int number) {
        if (pointer < CAPACITY) {
            stack[pointer++] = number;
        }
    }

    public static int pop() {
        return (pointer > 0) ? stack[--pointer] : -1;
    }

    public static int size() {
        return pointer;
    }

    public static int empty() {
        return (pointer == 0) ? 1 : 0;
    }

    public static int top() {
        return (pointer == 0) ? -1 : stack[pointer - 1];
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static void append(int number) {
        sb.append(number).append(NEW_LINE);
    }
}
