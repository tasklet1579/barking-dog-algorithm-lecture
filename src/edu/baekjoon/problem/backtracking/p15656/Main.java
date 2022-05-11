package edu.baekjoon.problem.backtracking.p15656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";
    private static final String NEW_LINE = "\n";

    private static int N;
    private static int M;
    private static int[] numbers;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITER);
        N = readInt(info.nextToken());
        M = readInt(info.nextToken());
        numbers = new int[N];
        answer = new int[M];

        numbers();

        Arrays.sort(numbers);

        sequence(0);

        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void numbers() throws IOException {
        StringTokenizer num = new StringTokenizer(readString(), DELIMITER);
        for (int idx = 0; idx < N; idx++) {
            numbers[idx] = readInt(num.nextToken());
        }
    }

    public static void sequence(int depth) {
        if (depth == M) {
            for (int num : answer) {
                sb.append(num).append(DELIMITER);
            }
            sb.append(NEW_LINE);
            return;
        }

        for (int idx = 0; idx < N; idx++) {
            answer[depth] = numbers[idx];
            sequence(depth + 1);
        }
    }
}
