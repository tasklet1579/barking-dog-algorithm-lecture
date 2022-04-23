package edu.baekjoon.problem.intro.p2752;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int[] numbers = new int[1000001];

        while (st.hasMoreTokens()) {
            int n = readInt(st.nextToken());
            numbers[n] = n;
        }

        for (int number : numbers) {
            if (number > 0) {
                System.out.print(number + DELIMITER);
            }
        }
        System.out.println();
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
