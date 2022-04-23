package edu.baekjoon.note.array;

public class Array {

    private int[] arr = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};

    public int insert(int loc, int num, int[] arr, int len) {
        for (int idx = len; idx > loc; idx--) {
            arr[idx] = arr[idx - 1];
        }
        arr[loc] = num;
        return len + 1;
    }

    public int erase(int loc, int[] arr, int len) {
        for (int idx = loc; idx < len; idx++) {
            arr[idx] = arr[idx + 1];
        }
        return len - 1;
    }
}
