package edu.baekjoon.problem.backtracking.p14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static int n;
    private static int m;
    private static int[] numbers;
    private static int[] visit;
    private static char[] operators;
    private static char[] formula;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        n = readInt(readString());
        numbers = new int[n];

        numbers();
        operators();
        m = operators.length;
        visit = new int[m];
        formula = new char[m];
        formula(0);

        System.out.println(max);
        System.out.println(min);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void numbers() throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITER);
        for (int idx = 0; idx < n; idx++) {
            numbers[idx] = readInt(info.nextToken());
        }
    }

    public static void operators() throws IOException {
        char[] sign = {'+', '-', '*', '/'};
        List<Character> chs = new LinkedList<>();
        StringTokenizer opr = new StringTokenizer(readString(), DELIMITER);
        for (int idx = 0; idx < 4; idx++) {
            int count = readInt(opr.nextToken());
            while (count-- > 0) {
                chs.add(sign[idx]);
            }
        }
        operators = new char[chs.size()];
        for (int idx = 0; idx < chs.size(); idx++) {
            operators[idx] = chs.get(idx);
        }
    }

    public static void formula(int depth) {
        if (depth == m) {
            calculate();
            return;
        }

        for (int idx = 0; idx < m; idx++) {
            if (visit[idx] == 0) {
                visit[idx] = 1;
                formula[depth] = operators[idx];
                formula(depth + 1);
                visit[idx] = 0;
            }
        }
    }

    public static void calculate() {
        int number = numbers[0];
        for (int idx = 1; idx < n; idx++) {
            switch (formula[idx - 1]) {
                case '+':
                    number = plus(number, numbers[idx]);
                    break;
                case '-':
                    number = minus(number, numbers[idx]);
                    break;
                case '*':
                    number = multiply(number, numbers[idx]);
                    break;
                case '/':
                    number = divide(number, numbers[idx]);
                    break;
            }
        }
        if (number > max) {
            max = number;
        }
        if (number < min) {
            min = number;
        }
    }

    public static int plus(int num1, int num2) {
        return num1 + num2;
    }

    public static int minus(int num1, int num2) {
        return num1 - num2;
    }

    public static int multiply(int num1, int num2) {
        return num1 * num2;
    }

    public static int divide(int num1, int num2) {
        return num1 / num2;
    }
}
