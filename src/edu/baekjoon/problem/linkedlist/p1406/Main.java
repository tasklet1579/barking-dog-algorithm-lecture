package edu.baekjoon.problem.linkedlist.p1406;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static final int SIZE = 600001;
    private static char[] data = new char[SIZE];
    private static int[] prev = new int[SIZE]; 
    private static int[] next = new int[SIZE]; 
    private static int current = 0; 
    private static int unused = 1;

    public static void main(String[] args) throws IOException {
        String text = readString();
        int count = readInt();
        Arrays.fill(prev, -1);
        Arrays.fill(next, -1);

        for (int idx = 0; idx < text.length(); idx++) {
            add(text.charAt(idx));
        }

        for (int idx = 0; idx < count; idx++) {
            text = readString();

            if (text.startsWith("L") && prev[current] != -1) { // ←
                current = prev[current];
            } else if (text.startsWith("D") && next[current] != -1) { // →
                current = next[current];
            } else if (text.startsWith("B") && prev[current] != -1) { // delete $
                delete();
            } else if (text.startsWith("P")) { // add $
                StringTokenizer st = new StringTokenizer(text, DELIMITER);
                st.nextToken();
                add(st.nextToken().charAt(0));
            }
        }

        print();
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
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
