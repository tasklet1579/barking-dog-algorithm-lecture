package edu.baekjoon.problem.bfs.p1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 고민해볼 문제
// BFS의 범위는 어디까지 제한할지?
// 수빈이가 이동 중에 반드시 0에서 100,000 사이에만 있어야 한다는 조건은 없다
// 0 보다 작은 곳으로 이동하면 가장 빠른 경로를 만족할 수 없기 때문에 제외한다
// 100,000 보다 큰 곳으로 이동할 수 있지만 그 후에는 X-1의 위치로만 이동할 것이다
// 그렇기 때문에 아무리 멀리가도 200,000 을 넘어가지는 않을 것이다
// 또 100,000 을 벗어나는 것 자체가 손해이고 2*X 후 X-1 하는 것 보다 X-1 하고 2*X 하는 게 더 낫다
public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITERS = " ";

    private static final int BEGIN = 0;
    private static final int END = 100000;
    private static final int SIZE = 100001;

    private static Queue<Integer> queue = new LinkedList<>();

    private static int[] visit = new int[SIZE];

    private static int[] dirX = {-1, 1, 2};
    private static char[] calculation = {'s', 'a', 'm'}; // subtraction, addition, multiplication

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(readString(), DELIMITERS);
        int subin = readInt(st.nextToken());
        int brother = readInt(st.nextToken());

        Arrays.fill(visit, -1);

        visit[subin] = 0;
        queue.offer(subin);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == brother) {
                System.out.println(visit[x]);
                break;
            }

            for (int idx = 0; idx < 3; idx++) {
                int nx = x;
                switch (calculation[idx]) {
                    case 's':
                    case 'a':
                        nx = nx + dirX[idx];
                        break;
                    case 'm':
                        nx = nx * dirX[idx];
                        break;
                }

                if (nx < BEGIN || nx > END) {
                    continue;
                }
                if (visit[nx] > -1) {
                    continue;
                }

                visit[nx] = visit[x] + 1;
                queue.offer(nx);
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
