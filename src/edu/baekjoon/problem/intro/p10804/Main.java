package edu.baekjoon.problem.intro.p10804;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        for (int idx = 0; idx < 10; idx++) {
            StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
            int begin = readInt(st.nextToken()) - 1;
            int end = readInt(st.nextToken()) - 1;

            while (begin <= end) {
                int temp = arr[begin];
                arr[begin++] = arr[end];
                arr[end--] = temp;
            }
        }
        
        for (int num : arr) {
            bw.write(num + DELIMITER);
        }
        bw.flush();
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
