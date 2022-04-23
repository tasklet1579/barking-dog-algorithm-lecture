package edu.baekjoon.note.intro;

public class Intro {

    // 시간복잡도 문제 1
    // N 이하의 자연수 중에서 3의 배수이거나 5의 배수인 수를 모두 합한 값을 반환하는 함수를 작성하라
    // N은 10만 이하의 자연수이다
    // O(n)
    public int func1(int n) {
        int ret = 0;
        for (int idx = 1; idx <= n; idx++) {
            if (idx % 3 == 0 || idx % 5 == 0) {
                ret += idx;
            }
        }
        return ret;
    }

    // 시간복잡도 문제 2
    // 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을
    // 존재하지 않으면 0을 반환하는 함수를 작성하라
    // arr의 각 수는 0이상 100 이하이고 N은 1000 이하이다
    // O(n²)
    public int func2(int[] arr, int n) {
        for (int idx = 0; idx < n; idx++) {
            for (int next = idx + 1; next < n; next++) {
                if (arr[idx] + arr[next] == 100) {
                    return 1;
                }
            }
        }
        return 0;
    }

    // 시간복잡도 문제 3
    // N이 제곱수이면 1을 반환하고 제곱수가 아니면 0을 반환하는 함수를 작성하라
    // N은 10억 이하의 자연수이다다
    // O(√n)
    public int func3(int n) {
        for (int idx = 1; idx * idx <= n; idx++) {
            if (idx * idx == n) {
                return 1;
            }
        }
        return 0;
    }

    // 시간복잡도 문제 4
    // N이하의 수 중에서 가장 큰 2의 거듭제곱수를 반환하는 함수를 작성하라
    // N은 10억 이하의 자연수이다
    // O(logN)
    public int func4(int n) {
        int val = 1;
        while (val * 2 <= n) {
            val *= 2;
        }
        return val;
    }

    // Integer Overflow 문제
    // 128번에 걸쳐 hi를 출력하는 함수
    // 127에서 1이 더해지면 -128이기 때문에
    // 의도한대로 동작하지 않고 무한루프 빠진다
    // 이를 해결하려면 char에서 int로 변경한다
    public void func5() {
        for (char c = 0; c < 128; c++) {
            System.out.println("hi");
        }
    }

    // Integer Overflow 문제
    // 50!을 61로 나눈 나머지를 반환하는 함수
    public void func6() {
        int r = 1;
        for (int idx = 1; idx <= 50; idx++) {
            r = (int) (r * idx % 6L);
        }
        System.out.println(r);
    }

    // Integer Overflow 문제
    // 10의 10 거듭제곱을 1000000007로 나눈 나머지를 반환하는 함수
    // i가 9일 때 int의 최대 범위를 넘어선다
    // 이를 해결하려면 int에서 long으로 변경하거나
    // 10 대신 10l 혹은 (long) 10으로 강제 형변환 한다
    public void func7() {
        int a = 1;
        int mod = 1000000007;
        for (int idx = 0; idx < 10; idx++) {
            a = 10 * a % mod;
        }
        System.out.println(a);
    }
}
