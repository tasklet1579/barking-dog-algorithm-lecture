package edu.baekjoon.problem.bracket.p4949;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String NEW_LINE = "\n";

    private static final char LEFT_SQUARE_BRACKET = '['; // ASCII 91
    private static final char RIGHT_SQUARE_BRACKET = ']'; // ASCII 93
    private static final char LEFT_ROUND_BRACKET = '('; // ASCII 40
    private static final char RIGHT_ROUND_BRACKET = ')'; // ASCII 41
    private static final char DOT = '.';
    private static final String YES = "yes";
    private static final String NO = "no";

    public static void main(String[] args) throws IOException {
        while (true) {
            Stack<Character> stack = new Stack<>();
            boolean err = false;

            char[] chars = readCharacter();
            if (chars[0] == DOT) {
                break;
            }

            for (char ch : chars) {
                switch (ch) {
                    case LEFT_SQUARE_BRACKET:
                    case LEFT_ROUND_BRACKET:
                        stack.push(ch);
                        break;
                    case RIGHT_SQUARE_BRACKET:
                    case RIGHT_ROUND_BRACKET:
                        if (stack.isEmpty()) {
                            err = true;
                            break;
                        }
                        if ((ch - 1) == stack.peek() || (ch - 2) == stack.peek()) {
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

        System.out.print(sb);
    }

    public static char[] readCharacter() throws IOException {
        return br.readLine().toCharArray();
    }

    public static void append(String answer) {
        sb.append(answer).append(NEW_LINE);
    }
}
