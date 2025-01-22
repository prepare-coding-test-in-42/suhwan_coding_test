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

### 소요시간
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