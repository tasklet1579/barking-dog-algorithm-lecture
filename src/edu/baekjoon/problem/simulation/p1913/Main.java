package edu.baekjoon.problem.simulation.p1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int rows = readInt(readString());
        int size = rows * rows;
        int number = readInt(readString());

        Queue<Position> positions = new LinkedList<>();
        positions.offer(new Position(rows));

        while (!positions.isEmpty()) {
            Position position = positions.poll();
            position.findNumber(number);

            if (position.isEnded(size)) {
                position.print();
                position.getAnswer();
                break;
            }

            positions.offer(position.moveNext());
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}

class Position {
    private int X;
    private int Y;
    private int answerX = 0;
    private int answerY = 0;
    private int direction = 0;
    private int begin = 0;
    private int end = 1;
    private int count = 1;
    private final int[][] visits;

    public Position(int rows) {
        X = rows / 2;
        Y = rows / 2;
        visits = new int[rows][rows];
        visits[X][Y] = 1;
    }

    public boolean isEnded(int count) {
        return this.count == count;
    }

    public Position moveNext() {
        if (direction == 0) {
            if (begin < end) {
                Y--;
                begin++;
            }
            if (begin == end) {
                begin = 0;
                direction = 1;
            }
        } else if (direction == 1) {
            if (begin < end) {
                X++;
                begin++;
            }
            if (begin == end) {
                begin = 0;
                end += 1;
                direction = 2;
            }
        } else if (direction == 2) {
            if (begin < end) {
                Y++;
                begin++;
            }
            if (begin == end) {
                begin = 0;
                direction = 3;
            }
        } else if (direction == 3) {
            if (begin < end) {
                X--;
                begin++;
            }
            if (begin == end) {
                begin = 0;
                end += 1;
                direction = 0;
            }
        }

        visits[Y][X] = ++count;

        return this;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        for (int[] visit : visits) {
            for (int v : visit) {
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public void findNumber(int number) {
        if (this.count == number) {
            answerX = X;
            answerY = Y;
        }
    }

    public void getAnswer() {
        System.out.println((answerY + 1) + " " + (answerX + 1));
    }
}
