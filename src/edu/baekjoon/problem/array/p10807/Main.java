package edu.baekjoon.problem.array.p10807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        readString();
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int number = readInt(readString());
        int count = 0;

        while (st.hasMoreTokens()) {
            if (number == readInt(st.nextToken())) {
                count++;
            }
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
