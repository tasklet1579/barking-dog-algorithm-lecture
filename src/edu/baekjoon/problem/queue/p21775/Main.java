package edu.baekjoon.problem.queue.p21775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final Map<Integer, Player> player = new HashMap<>();
    private static final Map<Integer, Integer> resource = new HashMap<>();
    private static final Queue<String> operation = new LinkedList<>();

    private static final String NEXT = "next";
    private static final String ACQUIRE = "acquire";
    private static final String RELEASE = "release";

    private static final String NEW_LINE = "\n";
    private static final String DELIMITER = " ";

    public static void main(String[] args) throws IOException {
        StringTokenizer info = new StringTokenizer(readString(), DELIMITER);
        StringTokenizer game = new StringTokenizer(readString(), DELIMITER);
        int peoples = readInt(info.nextToken());
        int turns = readInt(info.nextToken());

        for (int people = 1; people <= peoples; people++) {
            player.put(people, new Player());
        }

        for (int turn = 1; turn <= turns; turn++) {
            operation.offer(readString());
        }

        while (game.hasMoreTokens()) {
            int key = readInt(game.nextToken());
            Player value = player.get(key);
            String card;

            if (value.size() == 0) {
                card = operation.poll();
            } else {
                card = value.pool();
            }

            StringTokenizer st = new StringTokenizer(card, DELIMITER);
            int number = readInt(st.nextToken());
            switch (st.nextToken()) {
                case NEXT:
                    // 아무 일도 일어나지 않고 이 카드를 버립니다.
                    append(number);
                    break;
                case ACQUIRE:
                    // 자연수 n이 적혀진 자원 카드를 획득하려고 시도합니다.
                    // 만약 자연수 n이 적혀진 자원 카드가 공용 공간에 있다면
                    // 자신의 공간으로 자원 카드를 가져온 다음에, acquire n 카드를 버립니다.
                    // 그렇지 않고, 자원 카드가 다른 누군가의 공간에 있는 경우에는
                    // 이 카드를 버리지 않고 돌아오는 자신의 다음 차례에 재사용합니다.
                    int n = readInt(st.nextToken());
                    if (resource.containsKey(n)) {
                        value.offer(card);
                    } else {
                        resource.put(n, n);
                    }
                    append(number);
                    break;
                case RELEASE:
                    // 자연수 n이 적혀진 자원 카드를 공용 공간에 반납하고, 이 카드를 버립니다.
                    resource.remove(readInt(st.nextToken()));
                    append(number);
                    break;
            }

            player.put(key, value);
        }

        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void append(int number) {
        sb.append(number).append(NEW_LINE);
    }
}

class Player {

    private Queue<String> cards = new LinkedList<>(); // 연산 카드

    public Player() { }

    public void offer(String card) {
        cards.offer(card);
    }

    public String pool() {
        return cards.poll();
    }

    public int size() {
        return cards.size();
    }
}
