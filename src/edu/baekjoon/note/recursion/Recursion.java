package edu.baekjoon.note.recursion;

public class Recursion {

    // N부터 1까지 출력하는 함수
    public void func1(int n) {
        if (n == 0) { // Base condition
            return;
        }

        System.out.println(n);

        func1(n - 1);
    }

    // 1부터 N까지의 합을 구하는 함수
    public int func2(int n) {
        if (n == 0) {
            return 0;
        }

        return n + func2(n - 1);
    }

    // n번째 피보나치 수열을 반환하는 함수
    // 초항 2개가 1 1이고 그 뒤의 항들은 직전 항 2개의 합으로 정의됨
    public int fibo(int n) {
        if (n <= 1) {
            return 1;
        }

        return fibo(n - 1) + fibo(n - 2);
    }
}
