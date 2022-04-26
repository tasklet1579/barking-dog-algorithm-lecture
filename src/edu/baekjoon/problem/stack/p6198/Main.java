package edu.baekjoon.problem.stack.p6198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final Stack<Tower> towers = new Stack<>();

    private static long answer = 0;

    public static void main(String[] args) throws IOException {
        int count = readInt();

        for (int idx = 0; idx < count; idx++) {
            long height = readInt();
            while (!towers.empty()) {
                if (height >= towers.peek().height()) {
                    towers.pop();
                } else {
                    answer += towers.size();
                    break;
                }
            }
            towers.add(new Tower(height));
        }

        System.out.println(answer);
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}

class Tower {
    private long height;

    public Tower(long height) {
        this.height = height;
    }

    public long height() {
        return height;
    }
}
