package edu.baekjoon.problem.array.p13300;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int total = readInt(st.nextToken());
        int k = readInt(st.nextToken());
        int[][] rooms = new int[7][2];
        int room = 0;

        for (int idx = 0; idx < total; idx++) {
            st = new StringTokenizer(readString(), DELIMITER);
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());

            if (rooms[grade][sex] == 0) {
                room++;
            }

            rooms[grade][sex] += 1;

            if (rooms[grade][sex] == k) {
                rooms[grade][sex] = 0;
            }
        }

        System.out.println(room);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
