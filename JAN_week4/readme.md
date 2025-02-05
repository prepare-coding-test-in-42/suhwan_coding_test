## [최소직사각형_86491](https://school.programmers.co.kr/learn/courses/30/lessons/86491)

### 소요 시간
- 5분

### 간단 풀이 방법
- 각 명함의 row, col을 순회하면서 두 크기 비교 후 col이 더 크다면 명함을 회전시킨다
- row와 col의 max값을 곱한다

### pseudo code
```java
if (row < col) {
    maxRow.add(col);
    maxCol.add(row);
    continue;
}
```

### 시간 복잡도
- O(N^2)

### 실행시간 및 메모리
- 최소 : 0.05ms, 69.9MB
- 최대 : 5.48ms, 100MB

## [모의고사_42840](https://school.programmers.co.kr/learn/courses/30/lessons/42840)

### 소요 시간
- 15분

### 간단 풀이 방법
- 수포자의 정답 배열을 만든 후, answer과 순회하면서 맞힌 개수를 count
- 맞힌 갯수 기준 내림차순으로 정렬 후, 가장 많이 맞춘 max 갯수와 같으면 answer list에 저장

### psuedo codecode
```java
for (int i = 0; i < 3; ++i) {
    int len = gaveUpMath[i].length;
    int count = 0;
    for (int j = 0; j < answerLen; ++j) {
        if (answer[j] == gaveUpMath[i][j % len]) {
            count++;
        }
    }
    if (count == 0) {
        continue;
    }
    max = Math.max(max, count);
    result.add(new PersonInfo(i + 1, count));
}
```

### 시간 복잡도
- O(n)

## 실행 시간 및 메모리
- 최소 : 3.72ms, 81MB
- 최대 : 12.74ms, 103MB

## [소수찾기_42839](https://school.programmers.co.kr/learn/courses/30/lessons/42839)

### 소요 시간
- 25분

### 간단 풀이 방법
- 재귀를 돌면서, 빈 문자열에 number의 요소들을 하나씩 추가하여, 조합할 수 있는 모든 숫자를 만들어 set에 넣는다(중복제거)
- set 순회하면서, 소수인지 판별(에라토스테네스의 체)

### pseudo code
```java
for (int i = 0; i < num.length(); ++i) {
    if (!visited[i]) {
        visited[i] = true;
        set.add(Integer.parseInt(curr + num.charAt(i)));
        dfs(num, curr + num.charAt(i), depth + 1);
        visited[i] = false;
    }
}
```

### 시간 복잡도
- O(n!)

### 실행 시간 및 메모리
- 최소 : 14.07ms, 73.7MB
- 최대 : 37.83ms, 96.8MB

## [카펫_42842](https://school.programmers.co.kr/learn/courses/30/lessons/42842)

### 소요 시간
- 30분

### 간단 풀이 방법
- 노랑의 최소 : 1, 갈색의 최소 : 8 즉, 3 * 3 사각형가 최소이다
- 가로, 세로의 길이 시작 값을 최소 3으로 설정
- 3부터 가로 + 세로 길이를 순회하면서, (가로 - 2) * (세로 - 2) == 노랑 갯수 일때까지 구한다
- 정답은 가로 + 세로 길이의 약수인 것을 알 수 있기에, 큰값은 갈색, 작은값은 노랑이며 (노랑 - 2) * (갈색 - 2) == 노랑 갯수를 찾을 수 있다

### pseudo code
```java
if (row >= i) {
    if ((row - 2) * (i - 2) == yellow) {
        result.add(row);
        result.add(i);
        break ;
    }
}
```

### 시간복잡도
- O(N)

### 실행시간 및 메모리
- 최소 : 1.84ms, 70.2MB
- 최대 : 2.88ms, 88.9MB

## [던전_87946](https://school.programmers.co.kr/learn/courses/30/lessons/87946)

### 소요 시간
- 40분 (dfs 까먹었어우)

### 간단 풀이 방법
- dfs를 돌면서, 던전 배열을 들어가는 모든 조합을 완전 탐색하여 피로도를 구한다

### pseudo code
```java
private void dfs(int depth, int fatigue, int[][] dungeon) {
    for (int i = 0; i < dungeon.length; ++i) {
        if (visited[i] || dungeon[i][0] > fatigue) {
            continue;
        }
        visited[i] = true;
        dfs(depth + 1, fatigue - dungeon[i][1], dungeon);
        visited[i] = false;
    }
    answer = Math.max(answer, depth);
}
```

### 시간 복잡도
- O(N!)

### 실행 시간 및 메모리
- 최소 : 0.04ms, 70.6MB
- 최대 : 3.27ms, 87.6MB

## [모음사전_84512](https://school.programmers.co.kr/learn/courses/30/lessons/84512)

### 소요시간
- 15분

### 간단 풀이 방법
- {a, e, i, o, u} 배열을 만들고, 재귀를 통해 각 요소로 만들수 있는 중복 허용한 단어(길이 5이하)를 모두 구한다
- list안에서 주어진 word의 인덱스를 찾으면 정답

### pseudo code
```java
private void dfs(int depth, String str) {
    list.add(str);
    if (depth == MAX_LENGTH) {
        return;
    }

    for (int i = 0; i < VOWEL.length; ++i) {
        dfs(depth + 1, str + VOWEL[i]);
    }
}
```

### 시간 복잡도
- O(5^5) (문자 길이가 5)

### 실행 시간 및 메모리
- 최소 : 2.74ms, 71.8MB
- 최대 : 5.29ms, 99.9MB

## [전력망_둘로_나누기_86971](https://school.programmers.co.kr/learn/courses/30/lessons/86971)

### 소요시간
- 하루

### 간단 풀이 방법 (간단 맞음?)
- 송전탑은 양방향으로 연결되어있기 때문에, 그래프라고 생각하여 노드를 생성해서 이어준다 (이어져 있다면 1, 그렇지 않으면 0)
- 각 왼쪽 송전탑을 기준으로 순회하면서, 연결되어있는 오른쪽 송전탑을 끊고, bfs를 순회하면서 자신과 연결되어있는 송전탑을 갯수를 구한다
- 가장 적은 연결 갯수를 구해, return

### pseudo code
```java
private int bfs(int left, int n) {
    int cnt = 1;
    boolean[] visited = new boolean[n + 1];
    Queue<Integer> q = new LinkedList<>();

    q.add(left);

    while(!q.isEmpty()) {
        int curr = q.poll();
        visited[curr] = true;
        for (int i = 1; i < n + 1; ++i) {
            if (wireArray[curr][i] == 1 && !visited[i]) {
                q.add(i);
                cnt++;
            }
        }
    }
    return Math.abs(cnt - (n - cnt));
}
```

### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.12ms, 73.5MB
- 최대 : 13.15ms, 95.4MB

