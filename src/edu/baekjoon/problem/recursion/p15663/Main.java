package edu.baekjoon.problem.recursion.p15663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int N, M;
    private static int[][] number;
    private static int[] selection;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        st.nextToken();
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

    public static void number() throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);

        Map<Integer, Integer> hashMap = new TreeMap<>();

        while (st.hasMoreTokens()) {
            int num = readInt(st.nextToken());
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        N = hashMap.size();
        number = new int[N][2];

        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            number[idx][0] = entry.getKey();
            number[idx][1] = entry.getValue();
            idx++;
        }
    }

    public static void sequence(int depth) {
        if (depth == M) {
            print();
            return;
        }

        for (int idx = 0; idx < N; idx++) {
            if (number[idx][1] > 0) {
                number[idx][1] -= 1;
                selection[depth] = number[idx][0];
                sequence(depth + 1);
                number[idx][1] += 1;
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
