package edu.baekjoon.problem.bfs.p1012;

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
    private static final int SIZE = 50;

    private static final Queue<int[]> queue = new LinkedList<>();

    private static final int[][] board = new int[SIZE][SIZE];
    private static final int[][] visit = new int[SIZE][SIZE];

    private static final int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static final int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int count = readInt(readString());

        while (count-- > 0) {
            int answer = 0;
            StringTokenizer info = new StringTokenizer(readString(), DELIMITER);
            int rows = readInt(info.nextToken());
            int cols = readInt(info.nextToken());
            int cabbages = readInt(info.nextToken());

            for (int row = 0; row < rows; row++) {
                Arrays.fill(board[row], 0);
                Arrays.fill(visit[row], -1);
            }

            while (cabbages-- > 0) {
                StringTokenizer field = new StringTokenizer(readString(), DELIMITER);
                int x = readInt(field.nextToken());
                int y = readInt(field.nextToken());
                board[x][y] = 1;
                visit[x][y] = 0;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] == 0) {
                        continue;
                    }
                    if (visit[row][col] > 0) {
                        continue;
                    }

                    visit[row][col] = 1;
                    queue.offer(new int[] {row, col});

                    while (!queue.isEmpty()) {
                        int[] coordinate = queue.poll();
                        int x = coordinate[X];
                        int y = coordinate[Y];

                        for (int idx = 0; idx < 4; idx++) {
                            int nx = x + dirX[idx];
                            int ny = y + dirY[idx];

                            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                                continue;
                            }
                            if (board[nx][ny] == 0) {
                                continue;
                            }
                            if (visit[nx][ny] > 0) {
                                continue;
                            }

                            visit[nx][ny] = 1;
                            queue.offer(new int[] {nx, ny});
                        }
                    }

                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
