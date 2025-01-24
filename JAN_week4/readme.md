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

