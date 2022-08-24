### 달팽이2

- 시간 제한 2초
- 메모리 제한 128MB

문제

M줄 N칸으로 되어 있는 표 위에, 달팽이 모양으로 선을 그리려고 한다.

```
ㅇ 	  	 
  	  	 
  	  	 
  	  	 
  	  	 
```

위의 그림은 M=5, N=3의 예이다. 이제 표의 왼쪽 위 칸(ㅇ)에서 시작하여, 오른쪽으로 선을 그려 나간다. 표의 바깥 또는 이미 그려진 칸에 닿아서 더 이상 이동할 수 없게 되면, 시계방향으로 선을 꺾어서
그려나간다.

```
ㅇ 	→ 	↘
↗ 	↘ 	↓
↑ 	↓ 	↓
↑ 	끝 	↓
↖ 	← 	↙
```

위의 표는 선을 그려 나간 모양을 나타낸 것이다. 선이 꺾어진 부분은 대각선으로 나타내었다. 표의 모든 칸이 채워질 때까지, 선을 몇 번 꺾게 될까?

```
입력
첫째 줄에 M과 N이 빈 칸을 사이에 두고 주어진다. (2 ≤ M, N ≤ 100)

출력
첫째 줄에 표의 모든 칸이 채워질 때까지 선이 꺾어지는 횟수를 출력한다.

테스트 케이스
5 3

5
```