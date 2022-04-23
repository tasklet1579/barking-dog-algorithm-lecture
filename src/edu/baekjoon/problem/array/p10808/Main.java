package edu.baekjoon.problem.array.p10808;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final int ALPHABET_SIZE = 26;

     public static void main(String[] args) throws IOException {
        String str = readString();
        int[] alphabet = new int[ALPHABET_SIZE];

        for (int idx = 0; idx < str.length(); idx++) {
            alphabet[str.charAt(idx) - 'a'] += 1;
        }

        for (int idx = 0; idx < ALPHABET_SIZE; idx++) {
            System.out.print(alphabet[idx] + DELIMITER);
        }
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
