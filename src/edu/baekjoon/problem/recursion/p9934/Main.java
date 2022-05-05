package edu.baekjoon.problem.recursion.p9934;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int K;
    private static int[] tree;

    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        K = readInt(readString());
        K = (int) Math.pow(2, K);
        tree = new int[K];
        st = new StringTokenizer(readString(), DELIMITER);

        inorder(1);

        levelorder(1);

        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void inorder(int node) {
        if (node >= K) {
            return;
        }

        inorder(2 * node);
        tree[node] = readInt(st.nextToken());
        inorder(2 * node + 1);
    }

    public static void levelorder(int node) {
        if (node >= K) {
            return;
        }

        for (int idx = node; idx < 2 * node; idx++) {
            append(String.valueOf(tree[idx]));
            append(DELIMITER);
        }
        append(NEW_LINE);

        levelorder(2 * node);
    }

    public static void append(String str) {
        sb.append(str);
    }
}
