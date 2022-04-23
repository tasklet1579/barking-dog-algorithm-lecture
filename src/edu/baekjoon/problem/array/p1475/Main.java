package edu.baekjoon.problem.array.p1475;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int SIX = 6;
    private static final int NINE = 9;

    public static void main(String[] args) throws IOException {
        String str = readString();
        int[] numbers = {1, 1, 1, 1, 1, 1, 0, 1, 1, 2};
        int count = 1;

        for (int idx = 0; idx < str.length(); idx++) {
            int number = Character.getNumericValue(str.charAt(idx));
            if (numbers[number] >= 1) {
                numbers[number] -= 1;
                continue;
            }
            for (int n = 0; n < numbers.length; n++) {
                numbers[n] += 1;
            }
            numbers[SIX] = 0;
            numbers[NINE] += 1;
            numbers[number] -= 1;
            count++;
        }

        System.out.println(count);
    }

    public static String readString() throws IOException {
        return br.readLine().replaceAll(String.valueOf(SIX), String.valueOf(NINE));
    }
}
