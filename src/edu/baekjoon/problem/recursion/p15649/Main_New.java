package edu.baekjoon.problem.recursion.p15649;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 부분집합_재귀함수_순열 구하기
// 문과생이 적어보는 백트래킹
public class Main_New {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int N, M;
    private static int[] selection;

    private static LinkedList<Integer> number = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        N = readInt(st.nextToken());
        M = readInt(st.nextToken());
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
            number.add(idx + 1);
        }
    }

    public static void sequence(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int idx = 0; idx < N - depth; idx++) {
            selection[depth] = number.remove(idx);
            sequence(depth + 1);
            number.add(idx, selection[depth]);
        }
    }

    public static void print() {
        for (int idx = 0; idx < M; idx++) {
            sb.append(selection[idx]).append(DELIMITER);
        }
        sb.append(NEW_LINE);
    }
}
