package edu.baekjoon.problem.deque.p5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String NEW_LINE = "\n";

    private static final char R = 'R';
    private static final char D = 'D';
    private static final String BLANK = "";
    private static final String COMMA = ",";
    private static final String LEFT_BRACKET = "[";
    private static final String RIGHT_BRACKET = "]";
    private static final String ERROR = "error";

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        for (int idx = 0; idx < count; idx++) {
            Deque<Integer> deque = new LinkedList<>();
            int dir = 0; // 0 ASC, 1 DESC
            boolean err = false;

            char[] chars = readString().toCharArray();
            readString();
            StringTokenizer st = new StringTokenizer(replace(readString()), COMMA);

            while (st.hasMoreTokens()) {
                deque.offer(readInt(st.nextToken()));
            }

            for (char ch : chars) {
                switch (ch) {
                    case R:
                        dir ^= 1; // XOR
                        break;
                    case D:
                        if (deque.size() == 0) {
                            err = true;
                        } else {
                            if (dir == 0) {
                                deque.removeFirst();
                            } else {
                                deque.removeLast();
                            }
                        }
                        break;
                }

                if (err) {
                    break;
                }
            }

            if (err) {
                sb.append(ERROR).append(NEW_LINE);
            } else {
                sb.append(LEFT_BRACKET);
                List<String> numbers = new LinkedList<>();
                while (!deque.isEmpty()) {
                    if (dir == 0) {
                        numbers.add(String.valueOf(deque.removeFirst()));
                    } else {
                        numbers.add(String.valueOf(deque.removeLast()));
                    }
                }
                sb.append(String.join(COMMA, numbers));
                sb.append(RIGHT_BRACKET).append(NEW_LINE);
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

    public static String replace(String text) {
        return text.replace(LEFT_BRACKET, BLANK).replace(RIGHT_BRACKET, BLANK);
    }
}
