package edu.baekjoon.problem.intro.p2480;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int[] numbers = new int[7];
        int number = 0, max = 0, count = 1;

        for (int idx = 0; idx < 3; idx++) {
            int n = readInt(st.nextToken());
            numbers[n] += 1;

            if (max < n) {
                max = n;
            }

            if (numbers[n] == 2) {
                number = n;
                count = 2;
            }

            if (numbers[n] == 3) {
                number = n;
                count = 3;
            }
        }

        switch (count) {
            case 1:
                System.out.println(max * 100);
                break;
            case 2:
                System.out.println(1000 + number * 100);
                break;
            case 3:
                System.out.println(10000 + number * 1000);
                break;
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
