package edu.baekjoon.problem.stack.p10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String NEW_LINE = "\n";

    private static final int CAPACITY = 100000;
    private static int[] stack = new int[CAPACITY];
    private static int pointer = 0;

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());
        int result = 0; // int –2,147,483,648~2,147,483,647

        for (int idx = 0; idx < count; idx++) {
            int money = readInt(readString());
            if (money == 0) {
                pop();
            } else {
                push(money);
            }
        }

        while (!empty()) {
            result += pop();
        }
        System.out.println(result);
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

    public static boolean empty() {
        return pointer == 0;
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
