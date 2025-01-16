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

## [기능 개발 42586](https://school.programmers.co.kr/learn/courses/30/lessons/42586)

### 소요 시간
- 30분

### 간단 풀이 방법
- 각, 기능 완성 진행률 배열을 순회하면서, 큐에 기능 완성까지의 남은 일수를 넣는다
- 큐를 순회하면서, 기능 완성까지 남은 일수를 비교하며, 남은 일수보다 작거나 같으면, count++ 한다

### pseudo code
```java
while(!q.isEmpty()) {
    int leftDay = q.poll();
    int count = 1;

    while (!q.isEmpty() && q.peek() <= leftDay) {
        q.poll();
        count++;
    }
    answer.add(count);
}
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 0.29ms, 73.9MB
- 최대 : 0.50ms, 92.6MB

