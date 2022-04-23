package edu.baekjoon.problem.array.p11328;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final int ALPHABET_SIZE = 26;

    private static final String POSSIBLE = "Possible";
    private static final String IMPOSSIBLE = "Impossible";

     public static void main(String[] args) throws IOException {
         int count = readInt(readString());

         for (int idx = 0; idx < count; idx++) {
             int[] alphabet1 = new int[ALPHABET_SIZE];
             int[] alphabet2 = new int[ALPHABET_SIZE];
             boolean possible = true;

             StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
             String left = st.nextToken();
             String right = st.nextToken();

             if (left.length() != right.length()) {
                 System.out.println(IMPOSSIBLE);
                 continue;
             }

             for (int check = 0; check < left.length(); check++) {
                 alphabet1[left.charAt(check) - 'a'] += 1;
                 alphabet2[right.charAt(check) - 'a'] += 1;
             }

             for (int check = 0; check < ALPHABET_SIZE; check++) {
                 if (alphabet1[check] != alphabet2[check]) {
                     possible = false;
                     break;
                 }
             }

             if (possible) {
                 System.out.println(POSSIBLE);
             } else {
                 System.out.println(IMPOSSIBLE);
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
