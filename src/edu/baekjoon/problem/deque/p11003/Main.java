package edu.baekjoon.problem.deque.p11003;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
https://loosie.tistory.com/319 투 포인터와 슬라이딩 윈도우
https://ansohxxn.github.io/boj/11003 최소값 찾기
 */
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static final String DELIMITERS = " ";

    private static final int POSITION = 0;
    private static final int NUMBER = 1;

    private static Deque<int[]> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITERS);
        StringTokenizer num = new StringTokenizer(readString(), DELIMITERS);
        int count = readInt(info.nextToken());
        int width = readInt(info.nextToken());

        for (int idx = 1; idx <= count; idx++) {
            if (!deque.isEmpty()) {
                int[] ints = deque.peekFirst();
                if (ints[POSITION] == idx - width) {
                     deque.poll();
                }
            }

            int number = readInt(num.nextToken());
            while (!deque.isEmpty()) {
                int[] ints = deque.peekLast();
                if (ints[NUMBER] > number) {
                    deque.pollLast();
                } else {
                    break;
                }
            }

            deque.offer(new int[] {idx, number});
            bw.write(deque.peekFirst()[NUMBER] + DELIMITERS);
        }
        bw.flush();
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
