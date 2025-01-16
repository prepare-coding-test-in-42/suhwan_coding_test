## [같은 숫자는 싫어 12906](https://school.programmers.co.kr/learn/courses/30/lessons/12906)

### 소요 시간
- 30분 (set으로 먼저 풀었다가 회귀함)

### 간단 풀이 방법
- 배열을 순회하면서, 스택에 넣을 때, 스택에 가장 위의 요소와 같은 값이면 push하지 않고, 다르다면 push

### pseudo code
```java
for (int i = 0; i < arr.length; ++i) {
    if (i == 0) {
        stack.push(arr[i]);
    } else if (stack.peek() != arr[i]) {
        stack.push(arr[i]);
    }
}
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 2.09ms, 69.8MB
- 최대 : 3.81ms, 99.2MB