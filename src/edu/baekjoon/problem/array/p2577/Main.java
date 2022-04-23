package edu.baekjoon.problem.array.p2577;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

     public static void main(String[] args) throws IOException {
        int[] numbers = new int[10];
        int number = 1;

        for (int idx = 0; idx < 3; idx++) {
            number *= readInt(readString());
        }

        String str = String.valueOf(number);
        for (int i = 0; i < str.length(); i++) {
            numbers[str.charAt(i) - '0'] += 1;
        }

        for (int idx = 0; idx < 10; idx++) {
            System.out.println(numbers[idx]);
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
