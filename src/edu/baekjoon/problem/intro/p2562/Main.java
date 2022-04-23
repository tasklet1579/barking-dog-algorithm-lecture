package edu.baekjoon.problem.intro.p2562;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] number = new int[100];
        int[] order = new int[100];
        int idx = 1;

        while (idx <= 9) {
            int n = readInt(readString());
            number[n] = n;
            order[n] = idx++;
        }

        for (idx = 99; idx >= 0; idx--) {
            if (number[idx] > 0) {
                System.out.println(number[idx]);
                System.out.println(order[idx]);
                break;
            }
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
