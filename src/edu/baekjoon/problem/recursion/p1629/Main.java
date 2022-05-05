package edu.baekjoon.problem.recursion.p1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int base = readInt(st.nextToken());
        int exponent = readInt(st.nextToken());
        int number = readInt(st.nextToken());

        System.out.println(pow(base, exponent, number));
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static long pow(int base, int exponent, int number) {
        if (exponent == 1) {
            return base % number;
        }

        long answer = pow(base, exponent / 2, number);
        answer = answer * answer % number;

        if (exponent % 2 == 0) {
            return answer;
        }

        return answer * base % number;
    }
}
