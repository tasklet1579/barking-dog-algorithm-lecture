package edu.baekjoon.problem.array.p1919;

import java.io.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final int ALPHABET_SIZE = 26;

     public static void main(String[] args) throws IOException {
         int[] alphabet1 = new int[ALPHABET_SIZE];
         int[] alphabet2 = new int[ALPHABET_SIZE];
         String str1 = readString();
         String str2 = readString();
         int removal = 0;

         for (int idx = 0; idx < str1.length(); idx++) {
             alphabet1[str1.charAt(idx) - 'a'] += 1;
         }

         for (int idx = 0; idx < str2.length(); idx++) {
             alphabet2[str2.charAt(idx) - 'a'] += 1;
         }

         for (int idx = 0; idx < ALPHABET_SIZE; idx++) {
             if (alphabet1[idx] != alphabet2[idx]) {
                 removal += Math.abs(alphabet1[idx] - alphabet2[idx]);
             }
         }

         System.out.println(removal);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
