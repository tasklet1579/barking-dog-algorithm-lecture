package edu.baekjoon.problem.stack.p1874;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String NEW_LINE = "\n";

    private static final String PUSH = "+";
    private static final String POP = "-";
    private static final String NO = "NO";

    private static final int CAPACITY = 100000;
    private static int[] stack = new int[CAPACITY];
    private static int pointer = 0;
    private static int numberCount;

    public static void main(String[] args) throws IOException {
        numberCount = readInt(readString());

        for (int input = 1, begin = 1, end = numberCount; begin <= end; begin++) {
            int find = readInt(readString());
            int top = top();
            if (find < top) {
                break;
            }
            if (find > top) {
                while (find >= input) {
                    push(input++);
                    append(PUSH);
                }
            }
            find();
        }
        if (numberCount > 0) {
            error(NO);
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

    public static int top() {
        return (pointer == 0) ? -1 : stack[pointer - 1];
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static void append(String operation) {
        sb.append(operation).append(NEW_LINE);
    }

    private static void find() {
        pop();
        append(POP);
        numberCount--;
    }

    private static void error(String operation) {
        sb.setLength(0);
        sb.append(operation).append(NEW_LINE);
    }
}
