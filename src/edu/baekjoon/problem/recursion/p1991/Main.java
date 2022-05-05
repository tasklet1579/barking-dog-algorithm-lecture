package edu.baekjoon.problem.recursion.p1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final char NEW_LINE = '\n';
    private static final char DOT = '.';

    private static final int NODE = 0;
    private static final int LEFT = 0;
    private static final int RIGHT = 1;

    private static int N;
    private static int[][] tree;

    public static void main(String[] args) throws IOException {
        N = readInt(readString());
        tree = new int[N][2];

        init();
        tree();

        preorder(0);
        append(NEW_LINE);

        inorder(0);
        append(NEW_LINE);

        postorder(0);
        append(NEW_LINE);

        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void init() {
        for (int idx = 0; idx < N; idx++) {
            tree[idx][LEFT] = -1;
            tree[idx][RIGHT] = -1;
        }
    }

    public static void tree() throws IOException {
        for (int idx = 0; idx < N; idx++) {
            int position = 0;
            StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
            char parent = st.nextToken().charAt(NODE);

            while (st.hasMoreTokens()) {
                char child = st.nextToken().charAt(NODE);

                if (child != DOT) {
                    tree[parent - 'A'][position] = child - 'A';
                }
                position++;
            }
        }
    }

    public static void preorder(int node) {
        if (node == -1) {
            return;
        }

        append((char) (node + 'A'));
        preorder(tree[node][LEFT]);
        preorder(tree[node][RIGHT]);
    }

    public static void inorder(int node) {
        if (node == -1) {
            return;
        }

        inorder(tree[node][LEFT]);
        append((char) (node + 'A'));
        inorder(tree[node][RIGHT]);
    }

    public static void postorder(int node) {
        if (node == -1) {
            return;
        }

        postorder(tree[node][LEFT]);
        postorder(tree[node][RIGHT]);
        append((char) (node + 'A'));
    }

    public static void append(char ch) {
        sb.append(ch);
    }
}
