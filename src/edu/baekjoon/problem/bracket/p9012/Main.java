package edu.baekjoon.problem.bracket.p9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String NEW_LINE = "\n";

    private static final char LEFT_ROUND_BRACKET = '('; // ASCII 40
    private static final char RIGHT_ROUND_BRACKET = ')'; // ASCII 41
    private static final String YES = "YES";
    private static final String NO = "NO";

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        while (count-- > 0) {
            Stack<Character> stack = new Stack<>();
            boolean err = false;

            char[] chars = readCharacter();
            for (char ch : chars) {
                switch (ch) {
                    case LEFT_ROUND_BRACKET:
                        stack.push(ch);
                        break;
                    case RIGHT_ROUND_BRACKET:
                        if (stack.isEmpty()) {
                            err = true;
                            break;
                        }
                        if ((char) (ch - 1) == stack.peek()) {
                            stack.pop();
                        } else {
                            err = true;
                        }
                        break;
                }

                if (err) {
                    break;
                }
            }

            if (!err && stack.isEmpty()) {
                append(YES);
            } else {
                append(NO);
            }
        }

        System.out.println(sb);
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

    public static void append(String answer) {
        sb.append(answer).append(NEW_LINE);
    }
}
