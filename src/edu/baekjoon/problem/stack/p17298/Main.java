package edu.baekjoon.problem.stack.p17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITER = " ";

    private static Stack<Integer> stack = new Stack<>();
    private static int[] numbers;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());
        numbers = new int[count];
        answer = new int[count];
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);

        for (int idx = 0; idx < count; idx++) {
            numbers[idx] = readInt(st.nextToken());
        }

        for (int idx = count - 1; idx >= 0; idx--) {
            while (!stack.isEmpty()) {
                if (stack.peek() <= numbers[idx]) {
                    stack.pop();
                } else {
                    break;
                }
            }

            if (stack.isEmpty()) {
                answer[idx] = -1;
            } else {
                answer[idx] = stack.peek();
            }

            stack.add(numbers[idx]);
        }

        for (int idx = 0; idx < count; idx++) {
            sb.append(answer[idx])
              .append(DELIMITER);
        }

        System.out.println(sb);
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static String readString() throws IOException {
        return br.readLine();
    }
}
