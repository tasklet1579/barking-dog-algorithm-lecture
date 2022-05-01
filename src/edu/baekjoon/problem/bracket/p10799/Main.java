package edu.baekjoon.problem.bracket.p10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Stack<Integer> stack = new Stack<>();

    private static final char LEFT_ROUND_BRACKET = '('; // ASCII 40
    private static final char RIGHT_ROUND_BRACKET = ')'; // ASCII 41

    public static void main(String[] args) throws IOException {
        int answer = 0;
        String str = readString();

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            switch (ch) {
                case LEFT_ROUND_BRACKET:
                    stack.push(idx);
                    break;
                case RIGHT_ROUND_BRACKET:
                    int position = stack.pop();
                    if (idx - position == 1) {
                        answer += stack.size();
                    } else {
                        answer += 1;
                    }
                    break;
            }
        }

        System.out.println(answer);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
