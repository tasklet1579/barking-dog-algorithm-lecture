package edu.baekjoon.problem.recursion.p5904;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String M = "m";
    private static final String O = "o";

    private static int N;
    private static String answer;

    public static void main(String[] args) throws IOException {
        N = readInt(readString());
        moo(1, 3);
        System.out.println(answer);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void moo(int depth, int length) {
        if (N == 1 || N == length + 1) {
            answer = M;
            return;
        }
        if (N <= 3 || N <= length + depth + 3) {
            answer = O;
            return;
        }
        if (N <= 2 * length + depth + 3) {
            N = N - length - depth - 3;
            moo(1, 3);
            return;
        }

        moo(depth + 1, 2 * length + depth + 3);
    }
}
