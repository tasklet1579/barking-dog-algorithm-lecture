package edu.baekjoon.problem.array.p3273;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

     public static void main(String[] args) throws IOException {
         readString();
         StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
         int sum = Integer.parseInt(readString());
         int count = 0;
         int[] numbers = new int[2000001];

         while (st.hasMoreTokens()) {
             int number = readInt(st.nextToken());
             if (number >= sum) {
                 continue;
             }
             if (numbers[sum - number] == 1) {
                 count++;
             }
             numbers[number] = 1;
         }

         System.out.println(count);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
