package edu.baekjoon.problem.intro.p10871;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st1 = new StringTokenizer(readString(), DELIMITER);
        StringTokenizer st2 = new StringTokenizer(readString(), DELIMITER);
        int N = readInt(st1.nextToken());
        int X = readInt(st1.nextToken());

        for (int idx = 0; idx < N; idx++) {
            int Y = readInt(st2.nextToken());
            if (Y < X) {
                bw.write(Y + DELIMITER);
            }
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
