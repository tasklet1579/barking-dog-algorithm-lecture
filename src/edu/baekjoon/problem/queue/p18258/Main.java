package edu.baekjoon.problem.queue.p18258;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final String DELIMITERS = " ";
    private static final String NEW_LINE = "\n";
    private static final String PUSH = "push";
    private static final String POP = "pop";
    private static final String SIZE = "size";
    private static final String EMPTY = "empty";
    private static final String FRONT = "front";
    private static final String BACK = "back";

    public static void main(String[] args) throws IOException {
        Queue queue = new Queue();
        int count = readInt(readString());

        for (int idx = 0; idx < count; idx++) {
            StringTokenizer st = new StringTokenizer(readString(), DELIMITERS);
            String command = st.nextToken();

            switch (command) {
                case PUSH:
                    Number number = new Number(readInt(st.nextToken()));
                    queue.push(number);
                    break;
                case POP:
                    append(queue.pop());
                    break;
                case SIZE:
                    append(queue.size());
                    break;
                case EMPTY:
                    append(queue.empty());
                    break;
                case FRONT:
                    append(queue.front());
                    break;
                case BACK:
                    append(queue.back());
                    break;
            }
        }
        System.out.println(sb);
    }

    public static int readInt(String text) {
        return Integer.parseInt(text);
    }

    public static String readString() throws IOException {
        return br.readLine();
    }

    public static void append(int x) {
        sb.append(x).append(NEW_LINE);
    }
}

class Number {

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}

class Queue {

    private Number head;
    private Number tail;
    private List<Number> numbers;

    public Queue() {
        Number dummy = new Number(-1);
        this.head = dummy;
        this.tail = dummy;
        this.numbers = new LinkedList<>();
    }

    public void push(Number number) {
        if (empty() == 1) {
            head = null;
            head = number;
        }
        tail = null;
        tail = number;
        numbers.add(number);
    }

    public int pop() {
        if (empty() == 1) {
            return -1;
        }
        Number number = head;
        remove();
        if (size() > 0) {
            head = null;
            head = get();
        } else {
            Number dummy = new Number(-1);
            this.head = dummy;
            this.tail = dummy;
        }
        return number.getNumber();
    }

    public int size() {
        return numbers.size();
    }

    public int empty() {
        return size() == 0 ? 1 : 0;
    }

    public int front() {
        if (empty() == 1) {
            return -1;
        }
        return head.getNumber();
    }

    public int back() {
        if (empty() == 1) {
            return -1;
        }
        return tail.getNumber();
    }

    private void remove() {
        numbers.remove(0);
    }

    private Number get() {
        return numbers.get(0);
    }
}
