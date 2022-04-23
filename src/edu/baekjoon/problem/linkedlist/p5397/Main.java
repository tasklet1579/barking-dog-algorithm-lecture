package edu.baekjoon.problem.linkedlist.p5397;

import java.io.*;
import java.util.Arrays;
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String NEW_LINE = "\n";

    private static final int SIZE = 600001;
    private static char[] data = new char[SIZE];
    private static int[] prev = new int[SIZE];
    private static int[] next = new int[SIZE];
    private static int current;
    private static int unused;

    public static void main(String[] args) throws IOException {
        String text = readString();
        int count = readInt(text);

        for (int i = 0; i < count; i++) {
            fill();
            current = 0;
            unused = 1;
            char[] arr = readString().toCharArray();
            for (char c : arr) {
                if (Character.compare(c, '-') == 0 && prev[current] != -1) { //
                    delete();
                } else if (Character.compare(c, '<') == 0 && prev[current] != -1) { // ←
                    current = prev[current];
                } else if (Character.compare(c, '>') == 0 && next[current] != -1) { // →
                    current = next[current];
                } else if (c - 'A' >= 0 && c - 'A' <= 25){
                    add(c);
                } else if (c - 'a' >= 0 && c - 'a' <= 25){
                    add(c);
                } else if (c - '0' >= 0 && c - '0' <= 9){
                    add(c);
                }
            }
            print();
        }
    }

    private static void fill() {
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static void add(char c) {
        data[unused] = c;
        prev[unused] = current;
        next[unused] = next[current];
        if (next[current] != -1) {
            prev[next[current]] = unused;
        }
        next[current] = unused;
        current = unused++;
    }

    private static void delete() {
        next[prev[current]] = next[current];
        if (next[current] != -1) {
            prev[next[current]] = prev[current];
        }
        current = prev[current];
    }

    private static void print() throws IOException {
        current = 0;
        while (next[current] != -1) {
            bw.write(String.valueOf(data[next[current]]));
            current = next[current];
        }
        bw.write(NEW_LINE);
        bw.flush();
    }
}
