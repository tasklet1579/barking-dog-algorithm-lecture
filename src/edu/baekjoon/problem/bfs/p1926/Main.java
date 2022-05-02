package edu.baekjoon.problem.bfs.p1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 도화지에 있는 모든 그림 찾기
// 상하좌우로 연결된 그림의 크기 계산
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITERS = " ";

    private static final int X = 0;
    private static final int Y = 1;
    private static final int SIZE = 500;

    private static Queue<int[]> queue = new LinkedList<>();

    private static int[][] board = new int[SIZE][SIZE];
    private static int[][] visit = new int[SIZE][SIZE];

    private static int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int count = 0;
        int width = 0;
        StringTokenizer info = new StringTokenizer(readString(), DELIMITERS);
        int rows = readInt(info.nextToken());
        int cols = readInt(info.nextToken());

        for (int row = 0; row < rows; row++) {
            StringTokenizer paint = new StringTokenizer(readString(), DELIMITERS);
            for (int col = 0; col < cols; col++) {
                board[row][col] = readInt(paint.nextToken());
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] == 0) {
                    continue;
                }
                if (visit[row][col] == 1) {
                    continue;
                }

                count++;
                int temp = 0;
                visit[row][col] = 1;
                queue.offer(new int[] {row, col});

                while (!queue.isEmpty()) {
                    int[] coordinate = queue.poll();
                    int x = coordinate[X];
                    int y = coordinate[Y];
                    temp++;

                    for (int idx = 0; idx < 4; idx++) {
                        int nx = x + dirX[idx];
                        int ny = y + dirY[idx];

                        if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                            continue;
                        }
                        if (board[nx][ny] == 0) {
                            continue;
                        }
                        if (visit[nx][ny] == 1) {
                            continue;
                        }

                        visit[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }

                if (temp > width) {
                    width = temp;
                }
            }
        }

        System.out.println(count);
        System.out.println(width);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
