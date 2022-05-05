package edu.baekjoon.problem.recursion.p1074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int N = readInt(st.nextToken());
        int r = readInt(st.nextToken());
        int c = readInt(st.nextToken());

        System.out.println(visit(N, r, c));
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static int visit(int N, int r, int c) {
        if (N == 0) {
            return 0;
        }
        int half = (int) Math.pow(2, N - 1);

        if (r < half && c < half) {
            return visit(N - 1, r, c);
        }
        if (r < half) {
            return half * half + visit(N - 1, r, c - half);
        }
        if (c < half) {
            return 2 * half * half + visit(N - 1, r - half, c);
        }

        return 3 * half * half + visit(N - 1, r - half, c - half);
    }
}
