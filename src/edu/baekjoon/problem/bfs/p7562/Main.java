package edu.baekjoon.problem.bfs.p7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final int X = 0;
    private static final int Y = 1;
    private static final int SIZE = 300;

    private static final Queue<int[]> queue = new LinkedList<>();

    private static final int[][] board = new int[SIZE][SIZE];
    private static final int[][] visit = new int[SIZE][SIZE];

    private static final int[] dirX = {-2, -1, 1, 2, 2, 1, -1, -2}; // ↗ ↘ ↙ ↖
    private static final int[] dirY = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        while (count-- > 0) {
            int rows = readInt(readString());
            StringTokenizer knight = new StringTokenizer(readString(), DELIMITER);
            StringTokenizer dest = new StringTokenizer(readString(), DELIMITER);
            int knightX = readInt(knight.nextToken());
            int knightY = readInt(knight.nextToken());
            int destinationX = readInt(dest.nextToken());
            int destinationY = readInt(dest.nextToken());

            for (int idx = 0; idx < rows; idx++) {
                Arrays.fill(board[idx], 0);
                Arrays.fill(visit[idx], -1);
            }

            board[knightX][knightY] = 1;
            visit[knightX][knightY] = 0;
            queue.clear();
            queue.offer(new int[] {knightX, knightY});

            while (!queue.isEmpty()) {
                int[] coordinate = queue.poll();
                int x = coordinate[X];
                int y = coordinate[Y];

                if (x == destinationX && y == destinationY) {
                    System.out.println(visit[x][y]);
                    break;
                }

                for (int idx = 0; idx < 8; idx++) {
                    int nx = x + dirX[idx];
                    int ny = y + dirY[idx];

                    if (nx < 0 || nx >= rows || ny < 0 || ny >= rows) {
                        continue;
                    }
                    if (board[nx][ny] == 1) {
                        continue;
                    }
                    if (visit[nx][ny] > -1) {
                        continue;
                    }

                    board[nx][ny] = 1;
                    visit[nx][ny] = visit[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
