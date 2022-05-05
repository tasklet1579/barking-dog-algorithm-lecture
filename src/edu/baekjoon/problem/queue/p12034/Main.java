package edu.baekjoon.problem.queue.p12034;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static PriorityQueue<Long> answer = new PriorityQueue<>();
    private static PriorityQueue<Long> discount = new PriorityQueue<>();
    private static PriorityQueue<Long> normal = new PriorityQueue<>();

    private static final double rate = 0.75;

    private static final String CASE = "Case #";
    private static final String COLON = ":";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        long count = readLong();

        for (int idx = 1; idx <= count; idx++) {
            long products = readLong();
            StringTokenizer st = new StringTokenizer(readString(), DELIMITER);

            while (st.hasMoreTokens()) {
                long price = Long.parseLong(st.nextToken());
                if (price % 4 == 0) {
                    normal.offer(price);
                } else {
                    discount.offer(price);
                }
            }

            do {
                long price = normal.poll();
                if (!discount.isEmpty() && discount.peek() == price * rate) {
                    answer.offer(discount.poll());
                } else {
                    discount.offer(price);
                }
            } while (!normal.isEmpty());

            printPrices(idx);
        }
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    public static void printPrices(int number) {
        StringBuilder sb = new StringBuilder();
        sb.append(CASE)
          .append(number)
          .append(COLON)
          .append(DELIMITER);
        while (!answer.isEmpty()) {
            sb.append(answer.poll())
              .append(DELIMITER);
        }
        System.out.println(sb);
    }
}
