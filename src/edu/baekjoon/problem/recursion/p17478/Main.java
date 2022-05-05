package edu.baekjoon.problem.recursion.p17478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static final String UNDERSCORE = "____";
    private static final String NEW_LINE = "\n";

    private static final StringBuilder sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws IOException {
        N = readInt(readString());
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append(NEW_LINE);
        print(0);
        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void print(int depth) {
        String indent = "";
        for (int idx = 0; idx < depth; idx++) {
            indent = indent.concat(UNDERSCORE);
        }

        sb.append(indent).append("\"재귀함수가 뭔가요?\"").append(NEW_LINE);

        if (depth == N) {
            sb.append(indent).append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append(NEW_LINE);
        } else {
            sb.append(indent).append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append(NEW_LINE);
            sb.append(indent).append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append(NEW_LINE);
            sb.append(indent).append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append(NEW_LINE);
            print(depth + 1);
        }

        sb.append(indent).append("라고 답변하였지.").append(NEW_LINE);
    }
}
