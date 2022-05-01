package edu.baekjoon.problem.bracket.p3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;
        int count = readInt(readString());

        while (count-- > 0) {
            Stack<Character> stack = new Stack<>();

            char[] chars = readCharacter();
            for (char ch : chars) {
                if (!stack.isEmpty() && ch == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()) {
                answer++;
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

    public static char[] readCharacter() throws IOException {
        return br.readLine().toCharArray();
    }
}
