package edu.baekjoon.problem.queue.p15828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";

    private static final Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int buffer = readInt();

        while (true) {
            int input = readInt();
            if (input == -1) {
                break;
            }
            if (input == 0 && queue.size() > 0) {
                queue.poll();
            }
            if (input >= 1 && queue.size() < buffer) {
                queue.offer(input);
            }
        }

        while (!queue.isEmpty()) {
            append(queue.poll());
        }
        System.out.println(sb);
    }

    public static int readInt() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void append(int input) {
        sb.append(input).append(DELIMITER);
    }
}
