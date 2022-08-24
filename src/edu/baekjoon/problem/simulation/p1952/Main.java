package edu.baekjoon.problem.simulation.p1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int rows = readInt(st.nextToken());
        int cols = readInt(st.nextToken());
        int size = rows * cols;

        Queue<Position> positions = new LinkedList<>();
        positions.offer(new Position(cols, rows));

        while (!positions.isEmpty()) {
            Position position = positions.poll();

            if (position.isEnded(size)) {
                System.out.println(position.getAnswer());
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
    private int X = 0;
    private int Y = 0;
    private int minX = 0;
    private int maxX;
    private int minY = 1;
    private int maxY;
    private int direction = 0;
    private int count = 1;
    private int answer = 0;

    public Position(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isEnded(int count) {
        return this.count == count;
    }

    public Position moveNext() {
        if (direction == 0) {
            if (X + 1 == maxX) {
                Y++;
                maxX--;
                answer++;
                direction = 1;
            } else {
                X++;
            }
        } else if (direction == 1) {
            if (Y + 1 == maxY) {
                X--;
                maxY--;
                answer++;
                direction = 2;
            } else {
                Y++;
            }
        } else if (direction == 2) {
            if (X == minX) {
                Y--;
                minX++;
                answer++;
                direction = 3;
            } else {
                X--;
            }
        } else if (direction == 3) {
            if (Y == minY) {
                X++;
                minY++;
                answer++;
                direction = 0;
            } else {
                Y--;
            }
        }

        count++;

        return this;
    }

    public int getAnswer() {
        return answer;
    }
}
