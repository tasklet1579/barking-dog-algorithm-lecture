package edu.baekjoon.problem.queue.p2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());
        int card;

        for (card = 1; card <= count; card++) {
            queue.add(card);
        }

        while (queue.peek() != null) {
            card = queue.poll();
            if (queue.peek() != null) {
                card = queue.poll();
                queue.add(card);
            }
        }
        System.out.println(card);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
