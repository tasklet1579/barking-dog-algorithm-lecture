package edu.baekjoon.problem.bracket.p2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final Stack<Bracket> brackets = new Stack<>();
    private static final Stack<Bracket> store = new Stack<>();
    private static final Stack<Bracket> answer = new Stack<>();

    private static final char LEFT_SQUARE_BRACKET = '['; // ASCII 91
    private static final char RIGHT_SQUARE_BRACKET = ']'; // ASCII 93
    private static final char LEFT_ROUND_BRACKET = '('; // ASCII 40
    private static final char RIGHT_ROUND_BRACKET = ')'; // ASCII 41

    public static void main(String[] args) throws IOException {
        boolean err = false;
        String str = readString();

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            switch (ch) {
                case LEFT_ROUND_BRACKET:
                case LEFT_SQUARE_BRACKET:
                    brackets.push(new Bracket(ch, idx));
                    break;
                case RIGHT_ROUND_BRACKET:
                case RIGHT_SQUARE_BRACKET:
                    if (brackets.isEmpty()) {
                        err = true;
                        break;
                    }
                    if (ch - 1 == brackets.peek().sign()) {
                        calculate(idx, 2);
                    } else if (ch - 2 == brackets.peek().sign()) {
                        calculate(idx, 3);
                    } else {
                        err = true;
                    }
                    break;
            }

            if (err) {
                break;
            }
        }

        int result = 0;
        if (!err && brackets.isEmpty()) {
            while (!answer.empty()) {
                result += answer.pop().value();
            }
        }
        System.out.println(result);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    private static void calculate(int position, int constant) {
        Bracket bracket = brackets.pop();
        if (bracket.position() == position - 1) {
            answer.push(new Bracket(bracket.sign(), bracket.position(), constant));
            return;
        }

        while (!answer.isEmpty()) {
            if (answer.peek().position() > bracket.position() && answer.peek().position() < position) {
                store.push(answer.pop());
            } else {
                break;
            }
        }

        if (store.size() == 1) {
            answer.push(new Bracket(bracket.sign(), bracket.position(), constant * store.pop().value()));
            return;
        }

        int value = 0;
        while (!store.isEmpty()) {
            value += store.pop().value();
        }
        answer.push(new Bracket(bracket.sign(), bracket.position(), constant * value));
    }
}

class Bracket {

    private final char sign;
    private final int position;
    private final int value;

    public Bracket(char sign, int position) {
        this.sign = sign;
        this.position = position;
        this.value = 0;
    }

    public Bracket(char sign, int position, int value) {
        this.sign = sign;
        this.position = position;
        this.value = value;
    }

    public char sign() {
        return sign;
    }

    public int position() {
        return position;
    }

    public int value() {
        return value;
    }
}