package edu.baekjoon.problem.simulation.p14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String DELIMITER = " ";

    private static int n;
    private static int[] visit;
    private static int[] player;
    private static int[] pick;
    private static int[][] ability;
    private static long answer = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        makeAbility();

        pickTeamPlayers(0, 0);

        printAnswer();
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void init() throws IOException {
        n = readInt(readString());
        visit = new int[n];
        ability = new int[n][n];
    }

    public static void makeAbility() throws IOException {
        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(readString(), DELIMITER);
            for (int col = 0; col < n; col++) {
                ability[row][col] = readInt(st.nextToken());
            }
        }
    }

    public static void pickTeamPlayers(int depth, int begin) {
        if (n / 2 == depth) {
            calculateAbility();
            return;
        }

        for (int idx = begin; idx < n; idx++) {
            if (visit[idx] == 0) {
                visit[idx] = 1;
                pickTeamPlayers(depth + 1, idx + 1);
                visit[idx] = 0;
            }
        }
    }

    public static void makeTeam(int selection) {
        player = new int[n / 2];
        pick = new int[n / 2];
        int p = 0;

        for (int idx = 0; idx < n; idx++) {
            if (visit[idx] == selection) {
                player[p++] = idx;
            }
        }
    }

    public static void calculateAbility() {
        int startTeamAbility;
        int linkTeamAbility;

        makeTeam(1);

        startTeamAbility = addTeamAbility(0, 0, 0);

        makeTeam(0);

        linkTeamAbility = addTeamAbility(0, 0, 0);

        int diff = Math.abs(startTeamAbility - linkTeamAbility);
        if (answer > diff) {
            answer = diff;
        }
    }

    public static int addTeamAbility(int depth, int begin, int sum) {
        if (depth == 2) {
            int[] numbers = new int[2];
            int p = 0;
            for (int idx = 0; idx < n / 2; idx++) {
                if (pick[idx] == 1) {
                    numbers[p++] = player[idx];
                }
            }
            return sum + ability[numbers[0]][numbers[1]] + ability[numbers[1]][numbers[0]];
        }

        for (int idx = begin; idx < n / 2; idx++) {
            if (pick[idx] == 0) {
                pick[idx] = 1;
                sum = addTeamAbility(depth + 1, idx + 1, sum);
                pick[idx] = 0;
            }
        }

        return sum;
    }

    public static void printAnswer() {
        System.out.println(answer);
    }
}
