package edu.baekjoon.problem.bfs.p7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 다차원 배열에서의 거리 측정
// BFS를 이용하면 시작점과의 거리를 모두 계산할 수 있다
// 큐에는 거리 순으로 데이터가 쌓인다
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final int X = 0;
    private static final int Y = 1;

    private static Queue<int[]> queue = new LinkedList<>();

    private static int[][] board = new int[1000][1000];
    private static int[][] days = new int[1000][1000];

    private static int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITER);
        int cols = readInt(info.nextToken());
        int rows = readInt(info.nextToken());
        int tomatoes = 0;
        int answer = 0;

        for (int row = 0; row < rows; row++) {
            Arrays.fill(days[row], -1);
        }

        for (int row = 0; row < rows; row++) {
            StringTokenizer box = new StringTokenizer(readString(), DELIMITER);
            for (int col = 0; col < cols; col++) {
                board[row][col] = readInt(box.nextToken());
                if (board[row][col] == 0) {
                    tomatoes++;
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (board[row][col] <= 0) {
                    continue;
                }

                days[row][col] = 0;
                queue.offer(new int[] {row, col});
            }
        }

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
                if (board[nx][ny] == 1 || board[nx][ny] == -1) {
                    continue;
                }
                if (days[nx][ny] > -1) {
                    continue;
                }

                tomatoes--;
                answer = days[x][y] + 1;
                days[nx][ny] = answer;
                queue.offer(new int[] {nx, ny});
            }
        }

        if (tomatoes > 0) {
            answer = -1;
        }
        System.out.println(answer);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
