package edu.baekjoon.problem.backtracking.p6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb;

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int k;
    private static int[] numbers;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        while (true) {
            StringTokenizer num = new StringTokenizer(readString(), DELIMITER);
            k = readInt(num.nextToken());
            if (k == 0) {
                break;
            }
            numbers = new int[k];
            answer = new int[6];
            sb = new StringBuilder();
            numbers(num);
            lotto(0, 0);
            System.out.println(sb);
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void numbers(StringTokenizer num) {
        for (int idx = 0; idx < k; idx++) {
            numbers[idx] = readInt(num.nextToken());
        }
    }

    public static void lotto(int depth, int loc) {
        if (depth == 6) {
            print();
            return;
        }

        for (int idx = loc; idx < k; idx++) {
            answer[depth] = numbers[idx];
            lotto(depth + 1, idx + 1);
        }
    }

    public static void print() {
        for (int idx = 0; idx < 6; idx++) {
            sb.append(answer[idx])
              .append(DELIMITER);
        }
        sb.append(NEW_LINE);
    }
}
