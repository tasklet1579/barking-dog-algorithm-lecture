package edu.baekjoon.problem.linkedlist.p1158;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String DELIMITER = " ";

    private static int[] data;
    private static int[] prev;
    private static int[] next;
    private static int current = 0;
    private static int unused = 1;

    public static void main(String[] args) throws IOException {
        String text = readString();
        StringTokenizer st = new StringTokenizer(text, DELIMITER);
        int n = readInt(st.nextToken());
        int k = readInt(st.nextToken());
        List<Integer> numbers = new LinkedList<>();

        data = new int[n + 1];
        prev = new int[n + 1];
        next = new int[n + 1];

        for (int idx = 1; idx <= n; idx++) {
            add(idx);
        }
        prev[1] = current;
        next[current] = 1;
        current = 0;

        while (n > 0) {
            for (int c = 0; c < k; c++) {
                current = next[current];
            }
            numbers.add(data[current]);
            delete();
            n--;
        }

        bw.write("<");
        for (int idx = 0; idx < numbers.size(); idx++) {
            bw.write(numbers.get(idx) + "");
            if (idx < numbers.size() - 1) {
                bw.write(", ");
            }
        }
        bw.write(">");
        bw.flush();
    }

    private static String readString() throws IOException {
        return br.readLine();
    }

    private static int readInt(String text) {
        return Integer.parseInt(text);
    }

    private static void add(int i) {
        data[unused] = i;
        prev[unused] = current;
        next[unused] = next[current];
        if (next[current] != -1) { // 원소 A B 사이에 C가 삽입되면
            prev[next[current]] = unused;  // 원소 B는 삽입된 원소 C를 가리킨다
        }
        next[current] = unused;
        current = unused++;
    }

    private static void delete() {
        next[prev[current]] = next[current];
        if (next[current] != -1) { // 다음 위치에 원소가 존재하면
            prev[next[current]] = prev[current];
        }
        current = prev[current];
    }
}
