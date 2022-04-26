package edu.baekjoon.problem.stack.p2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";

    private static Stack<Tower> towers = new Stack<>();

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);

        for (int idx = 0; idx < count; idx++) {
            int height = readInt(st.nextToken());
            while (!towers.isEmpty()) {
                if (height > towers.peek().height()) {
                    towers.pop();
                } else {
                    break;
                }
            }

            if (towers.isEmpty()) {
                sb.append(0)
                  .append(DELIMITER);
            } else {
                sb.append(towers.peek().position())
                  .append(DELIMITER);
            }
            towers.add(new Tower(height, idx + 1));
        }

        System.out.println(sb);
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static void append(int number) {
        sb.append(number).append(" ");
    }
}

class Tower {
    private long height;
    private int position;

    public Tower(long height, int position) {
        this.height = height;
        this.position = position;
    }

    public long height() {
        return height;
    }

    public int position() {
        return position;
    }
}
