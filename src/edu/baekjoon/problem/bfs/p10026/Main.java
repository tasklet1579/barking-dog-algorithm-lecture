package edu.baekjoon.problem.bfs.p10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final char RED = 'R';
    private static final char GREEN = 'G';
    private static final char BLUE = 'B';

    private static final int X = 0;
    private static final int Y = 1;
    private static final int SIZE = 100;

    private static final int[] RGB = new int[128];

    private static final Queue<int[]> queue = new LinkedList<>();

    private static final char[][] board = new char[SIZE][SIZE];
    private static final char[][] backup = new char[SIZE][SIZE];
    private static final int[][] visit = new int[SIZE][SIZE];

    private static final int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static final int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int rows = readInt(readString());

        for (int row = 0; row < rows; row++) {
            String str = readString();
            for (int col = 0; col < rows; col++) {
                board[row][col] = str.charAt(col);
                backup[row][col] = board[row][col];
                if (backup[row][col] == RED) {
                    backup[row][col] = GREEN;
                }
                visit[row][col] = 0;
            }
        }

        for (int count = 0; count < 2; count++) {
            for (int idx = 0; idx < rows; idx++) {
                Arrays.fill(visit[idx], -1);
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < rows; col++) {
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

                            if (nx < 0 || nx >= rows || ny < 0 || ny >= rows) {
                                continue;
                            }
                            if (visit[nx][ny] > 0) {
                                continue;
                            }

                            if (board[nx][ny] == board[row][col]) {
                                visit[nx][ny] = 1;
                                queue.offer(new int[] {nx, ny});
                            }
                        }
                    }

                    RGB[board[row][col]] = RGB[board[row][col]] + 1;
                }
            }

            System.out.print((RGB[RED] + RGB[GREEN] + RGB[BLUE]) + DELIMITER);

            RGB[RED] = 0;
            RGB[BLUE] = 0;
            RGB[GREEN] = 0;

            for (int row = 0; row < rows; row++) {
                System.arraycopy(backup[row], 0, board[row], 0, backup[row].length);
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
