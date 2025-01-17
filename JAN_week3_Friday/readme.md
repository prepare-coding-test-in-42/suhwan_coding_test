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

## [디스크 컨트롤러_42627](https://school.programmers.co.kr/learn/courses/30/lessons/42627)

### 소요 시간
- 45분

### 간단 풀이 방법
- 요청된 작업들을 요청 시간 오름차순으로 큐에 저장한다.
- 메모리에서 처리될 큐를 선언하고, 소요 시간 순서 대로 저장한다.
- 각 2개의 큐가 empty할 때까지, 순회를 지속한다
- 현재 시간보다 요청 시간이 적은 process를 메모리에 올리고, 메모리에서 작업을 하면서 시간 계산을 실행
- total 시간 / 작업 사이즈로 return

### pseudo code
```java
while (!process.isEmpty() || !memory.isEmpty()) {
    while (!process.isEmpty() && process.peek().requestTime <= time) {
        memory.add(process.poll());
    }

    if (memory.isEmpty()) {
        time = process.peek().requestTime;
    } else {
        Process p = memory.poll();
        time += p.takeTime;
        answer += (time - p.requestTime);
    }
}
```

### 시간 복잡도
- O(NlongN)

### 실행 시간 및 메모리
- 최소 : 1.09ms, 70.5MB
- 최대 : 3.89ms, 89.8MB

## [이중우선순위큐_42628](https://school.programmers.co.kr/learn/courses/30/lessons/42628)

### 소요 시간
- 20분

### 간단 풀이 방법
- 우선순위 큐를 오름차순, 내림차순으로 저장하는 2개의 큐 선언
- operation을 순회하면서, 각 Command를 실행한다
    - "I" : 두 우선순위 큐에 add
    - "D -1" : 오름 차순 우선순위에서 poll
    - "D 1" : 내림 차순 우선순위에서 poll
- 두 큐가 비어있다면, [0, 0] return
- 그렇지 않다면, 각 큐에서 poll 후 return

### pseudo code
```java
if (cmd.equals("I")) {
    smallQueue.add(num);
    largeQueue.add(num);
}
if (cmd.equals("D")) {
    if (smallQueue.isEmpty() || largeQueue.isEmpty()) {
        continue;
    }
    if (num == -1) {
        int smallValue = smallQueue.poll();
        largeQueue.remove(smallValue);
    } else {
        int largeValue = largeQueue.poll();
        smallQueue.remove(largeValue);
    }
}
```

### 시간 복잡도
- 삽입 연산 : O(NlongN)
- 삭제 연산 : O(N^2)
- 최악 : O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.94ms, 73MB
- 최대 : 129.06ms, 124MB

## [K번째수_42748](https://school.programmers.co.kr/learn/courses/30/lessons/42748)

### 소요 시간
- 10분

### 간단 풀이 방법
- command에 주어진 대로, array 복사 후 정렬
- 해당 index 값을 list에 추가
- return (list -> int array 변환)

### pseudo code
```java
System.arraycopy(array, start - 1, subArray, 0, len);
Arrays.sort(subArray);
answer.add(subArray[index]);
```

### 시간 복잡도
- 복사 : O(N)
- 정렬 : O(MlogM)

### 실행 시간 및 메모리
- 최소 : 2.12ms, 70.6MB
- 최대 : 5.96mms, 99.2MB

## [가장 큰 수_42746](https://school.programmers.co.kr/learn/courses/30/lessons/42746)

### 소요 시간
- 5분

### 간단 풀이 방법
- 주어진 int[]를 string[]로 변환
- string[]을 "현재 + 다음" string으로 더한 후, 큰 값으로 정렬
- 하나의 string으로 return

### pseudo code
```java
Arrays.sort(numberArray, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 4.40ms, 77MB
- 최대 : 303.63ms, 139MB

## [다리를 지나는 트럭](https://school.programmers.co.kr/learn/courses/30/lessons/42583)

### 소요 시간
- 1시간

### 간단 풀이 방법
- 다리 지나는 시간을 담을 큐와, 트럭을 담을 큐 2개를 선언한다
- 무한 루프를 돌면서, 시간 큐가 비어있다면 모든 트럭이 다리를 건넜기에 break;
- 현재 트럭 위치를 나타내는 curr이 트럭 갯수를 넘지 않고, 다리가 현재 무게 + 트럭무게를 버틸 수 있다면, 시간은 시간큐에 트럭무게는 다리 큐에 담는다
- 만약, 현재 시간이 시간큐에 있는 도착 시간과 같다면 다리에서 무게를 빼주고, 시간큐에서도 제거한다

### pseudo code
```java
while(true) {
    if (!bridgeQueue.isEmpty() && arriveTimeQueue.peek() == totalTime) {
        arriveTimeQueue.poll();
        sum -= bridgeQueue.poll();
    }

    if (curr < truck_weights.length && sum + truck_weights[curr] <= weight) {
        arriveTimeQueue.add(totalTime + bridge_length);
        bridgeQueue.add(truck_weights[curr]);
        sum += truck_weights[curr];
        curr++;
    }

    totalTime++;
    if (arriveTimeQueue.isEmpty()) {
        break;
    }
}
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 0.08ms, 71.4MB
- 최대 : 23.22ms, 94.3MB