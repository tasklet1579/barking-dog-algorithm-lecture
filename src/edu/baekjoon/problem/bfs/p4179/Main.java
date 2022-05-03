package edu.baekjoon.problem.bfs.p4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 서로 다른 시작점의 성질이 독립적이지 않고 서로에게 영향을 준다면 지금 풀이 방법으로는 문제를 해결할 수 없다
// 그런 상황에서는 시간 순으로 A와 B를 동시에 진행시켜야 한다 (백준 18809 - 백트래킹)
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static final char SHARP = '#';
    private static final char JIHUN = 'J';
    private static final char FIRE = 'F';

    private static final String IMPOSSIBLE = "IMPOSSIBLE";

    private static final int X = 0;
    private static final int Y = 1;

    private static Queue<int[]> fires = new LinkedList<>();
    private static Queue<int[]> jihuns = new LinkedList<>();

    private static char[][] board = new char[1000][1000];
    private static int[][] fire = new int[1000][1000];
    private static int[][] jihun = new int[1000][1000];

    private static int[] dirX = {-1, 0, 1, 0}; // ↑ → ↓ ←
    private static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
        int rows = readInt(st.nextToken());
        int cols = readInt(st.nextToken());

        for (int row = 0; row < rows; row++) {
            Arrays.fill(fire[row], -1);
            Arrays.fill(jihun[row], -1);
        }

        for (int row = 0; row < rows; row++) {
            String str = readString();
            for (int col = 0; col < cols; col++) {
                board[row][col] = str.charAt(col);
                if (board[row][col] == FIRE) {
                    fire[row][col] = 0;
                    fires.offer(new int[] {row, col});
                }
                if (board[row][col] == JIHUN) {
                    jihun[row][col] = 0;
                    jihuns.offer(new int[] {row, col});
                }
            }
        }

        while (!fires.isEmpty()) {
            int[] coordinate = fires.poll();
            int x = coordinate[X];
            int y = coordinate[Y];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dirX[idx];
                int ny = y + dirY[idx];

                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    continue;
                }
                if (board[nx][ny] == FIRE || board[nx][ny] == SHARP) {
                    continue;
                }
                if (fire[nx][ny] > -1) {
                    continue;
                }

                fire[nx][ny] = fire[x][y] + 1;
                fires.offer(new int[] {nx, ny});
            }
        }

        while (!jihuns.isEmpty()) {
            int[] coordinate = jihuns.poll();
            int x = coordinate[X];
            int y = coordinate[Y];

            for (int idx = 0; idx < 4; idx++) {
                int nx = x + dirX[idx];
                int ny = y + dirY[idx];

                if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                    System.out.println(jihun[x][y] + 1);
                    return;
                }
                if (board[nx][ny] == FIRE || board[nx][ny] == SHARP || board[nx][ny] == JIHUN) {
                    continue;
                }
                if (jihun[nx][ny] > -1) {
                    continue;
                }
                if (fire[nx][ny] > -1 && jihun[x][y] + 1 >= fire[nx][ny]) {
                    continue;
                }

                jihun[nx][ny] = jihun[x][y] + 1;
                jihuns.offer(new int[] {nx, ny});
            }
        }

        System.out.println(IMPOSSIBLE);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }
}
