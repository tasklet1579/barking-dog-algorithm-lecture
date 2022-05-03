package edu.baekjoon.problem.bfs.p2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITERS = " ";

    private static final int X = 0;
    private static final int Y = 1;

    private static Queue<int[]> queue = new LinkedList<>();

    private static int[][] board = new int[100][100];
    private static int[][] distance = new int[100][100];

    private static int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITERS);
        int rows = readInt(st.nextToken());
        int cols = readInt(st.nextToken());

        for (int row = 0; row < rows; row++) {
            Arrays.fill(distance[row], -1);
        }

        for (int row = 0; row < rows; row++) {
            String str = readString();
            for (int col = 0; col < cols; col++) {
                board[row][col] = readInt(substring(str, col, col + 1));
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) {
                    continue;
                }

                distance[row][col] = 1;
                queue.offer(new int[] {row, col});
                row = rows;
                break;
            }
        }

        while (!queue.isEmpty()) {
            int[] coordinate = queue.poll();
            int x = coordinate[X];
            int y = coordinate[Y];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + dirX[dir];
                int ny = y + dirY[dir];

                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }
                if (board[nx][ny] == 0) {
                    continue;
                }
                if (distance[nx][ny] > -1) {
                    continue;
                }

                distance[nx][ny] = distance[x][y] + 1;
                queue.offer(new int[] {nx, ny});

                if (nx == rows - 1 && ny == cols - 1) {
                    queue.clear();
                    break;
                }
            }
        }

        System.out.println(distance[rows - 1][cols - 1]);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static String substring(String text, int begin, int end) {
        return text.substring(begin, end);
    }
}
