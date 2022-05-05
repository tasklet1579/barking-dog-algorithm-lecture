package edu.baekjoon.problem.recursion.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int N, M;
    private static int[] number, visit, selection;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        N = readInt(st.nextToken());
        M = readInt(st.nextToken());
        number = new int[N];
        visit = new int[N];
        selection = new int[M];

        number();

        sequence(0);

        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void number() {
        for (int idx = 0; idx < N; idx++) {
            number[idx] = idx + 1;
        }
    }

    public static void sequence(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int idx = 0; idx < N; idx++) {
            if (visit[idx] == 0) {
                visit[idx] = 1;
                selection[depth] = number[idx];
                sequence(depth + 1);
                visit[idx] = 0;
            }
        }
    }

    public static void print() {
        for (int idx = 0; idx < M; idx++) {
            sb.append(selection[idx]).append(DELIMITER);
        }
        sb.append(NEW_LINE);
    }
}
