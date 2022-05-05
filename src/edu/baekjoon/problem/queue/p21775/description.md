### 가희와 자원 놀이
- 시간 제한 2초
- 메모리 제한 512MB

문제

가희와 친구들은 자원 놀이를 하고 있습니다.

이 놀이는 T개의 연산 카드와, 1 부터 2×109 이하의 자연수가 한 장에 하나씩 순서대로 적혀져 있는 2×109개의 자원 카드를 이용합니다.

자원 놀이에서 사용하는 연산 카드의 종류는 3가지입니다.
- next
  - 아무 일도 일어나지 않고 이 카드를 버립니다.
- acquire n
  - 자연수 n이 적혀진 자원 카드를 획득하려고 시도합니다.
  - 만약 자연수 n이 적혀진 자원 카드가 공용 공간에 있다면 자신의 공간으로 자원 카드를 가져온 다음에, acquire n 카드를 버립니다.
  - 그렇지 않고, 자원 카드가 다른 누군가의 공간에 있는 경우에는 이 카드를 버리지 않고 돌아오는 자신의 다음 차례에 재사용합니다.
- release n
  - 자연수 n이 적혀진 자원 카드를 공용 공간에 반납하고, 이 카드를 버립니다.

게임의 규칙은 아래와 같습니다.
- 처음에 모든 자원 카드들과 연산 카드들은 공용 공간에 놓여져 있습니다.
- 각 턴을 수행하는 사람은 1명입니다.
- 자신의 턴이 돌아오면 다음의 행동을 수행합니다.
  - 연산 카드를 들고 있지 않은 경우
    - 더미의 맨 위에 있는 연산 카드를 뽑고, 해당 카드에 있는 연산을 즉시 수행합니다.
  - 연산 카드를 들고 있는 경우
    - 들고 있는 연산 카드에 있는 연산을 즉시 수행합니다.

처음 연산 카드 더미에 있던 연산 카드가 T개 주어지고, T 턴동안 각 턴을 수행한 사람의 번호가 주어집니다.

T 턴동안 수행된 연산 카드의 id를 알려주세요. 처음 더미에 있는 연산 카드의 갯수와 턴 수는 같습니다.
```
입력
첫 번째 줄에 자원 놀이에 참가하는 사람 수 N과 턴 수 T가 주어집니다.
두 번째 줄에 각 턴을 수행한 사람 번호가 T개 주어집니다.
세 번째 줄 부터 2+T번째 줄까지, 더미의 맨 위에 있는 카드부터, 더미에 있는 연산 카드의 id와 연산 카드에 적혀져 있는 연산이 공백으로 구분되어 주어집니다.

출력
T턴에 걸쳐서, 각 턴에 수행된 연산 카드의 id를 한 줄에 하나씩 출력해 주세요.

제한
1 ≤ N ≤ T ≤ 5×10⁵
1 ≤ 턴을 수행하는 사람의 번호 ≤ N
1 ≤ acquire나 release 연산에서 등장하는 수 ≤ 2×10⁹
자원 카드 n을 획득한 사람이 다시 acquire n을 수행하는 경우는 주어지지 않습니다.
획득하지 않은 자원 카드를 release 하는 경우는 주어지지 않습니다.
1 ≤ 더미에 있는 연산 카드의 id ≤ 5×10⁵
더미에 있는 연산 카드의 id는 모두 다릅니다.

테스트 케이스
2 10
1 1 2 2 1 1 2 2 2 2
1 next
2 acquire 1
3 acquire 1
4 next
5 release 1
6 release 1
7 next
8 acquire 1
9 next
10 next

1
2
3
3
4
5
3
6
7
8
```