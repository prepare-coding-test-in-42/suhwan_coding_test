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