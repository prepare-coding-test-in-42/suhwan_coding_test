## [더 맵게_42626](https://school.programmers.co.kr/learn/courses/30/lessons/42626)

### 소요 시간
- 10분

### 간단 풀이 방법
- 우선순위 큐에 스코빌지수 배열을 오름차순으로 넣는다
- 큐를 순회하면서, 현재 스코빌 지수가 K 보다 작을 경우, 다음 스코빌 지수와 섞는다
- 만약, 현재 스코빌 지수가 K보다 크거나 같다면 break

### pseudo code
```java
while(!pq.isEmpty()) {
    if (pq.peek() < K) {
        if (pq.size() < 2) {
            return -1;
        }
        int curr = pq.poll();
        int next = pq.poll();

        int newScoville = curr + (next * 2);
        pq.add(newScoville);
        answer++;
    } else {
        break;
    }

}
```

### 시간 복잡도
- poll() : O(2logN) -> 2번 실행
- add() : O(logN)
- peek() : O(1)
- 총 : O(NlongN)

### 실행 시간 및 메모리
- 0.70ms, 69MB
- 5.66ms, 97.5MB

## 