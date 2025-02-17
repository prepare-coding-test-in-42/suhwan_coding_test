## [체육복](https://school.programmers.co.kr/learn/courses/30/lessons/42862)

### 소요 시간
- 15분

### 간단 풀이 방법
- 잊어버린 학생과 여벌을 가지고 있는 학생이 같다면 -1로 설정
- 잊어버린 학생을 순회하면서, 나보다 사이즈가 한치수 작거나 큰 여벌옷이 있다면, 여벌옷을 -1로 처리하고 answer++

### pseudo code
```java
for (int i = 0; i < lost.length; ++i) {
    for (int j = 0; j < reserve.length; ++j) {
        if (lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
            answer++;
            reserve[j] = -1;
            break;
        }
    }
}
```

### 시간 복잡도
- O(n^2)

### 실행 시간 및 메모리 
- 최소 : 0.32ms, 71.5MB
- 최대 : 0.52ms, 90.5MB

## [조이스틱](https://school.programmers.co.kr/learn/courses/30/lessons/42860)

### 소요 시간
- 20분

### 간단 풀이 방법
- 주어진 이름을 순회하면서, 알파벳 정순과 역순으로 만들수 있는 최소의 값 추출
- 그 후 다음 알파벳이 A일 경우에는 좌측 혹은 우측으로 이동할 수 있지만, 가장 최선의 방법을 선택한다
- 각 알파벳으로 변경하는 수 (콘솔 위, 아래) + 각 알파벳 자리 이동 수 (콘솔 좌 우) return

### pseudo code
```java
for (int i = 0; i < len; ++i) {
    char c = name.charAt(i);
    if (c != 'A') {
        answer += Math.min(c - 65, 91 - c);
        index = i + 1;
        while (index < len && name.charAt(index) == 'A') {
            index++;
        }
        //뒤로 갈때 
        move = Math.min(move, i * 2 + len - index);
        // 앞으로 갈때
        move = Math.min(move, (len - index) * 2 + i);
    }
}
```

### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.02ms, 71,8MB
- 최대 : 0.10ms, 89.9MB

## [큰 수 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/42883)

### 소요 시간
- 40분

### 간단 풀이 방법
- 각 숫자를 k개의 수를 제거한 숫자의 길이 만큼 순회한다
- 순회 중, 그 구간에서 가장 큰 수를 구해 answer에 append 한다

### pseudo code
```java
for (int i = 0; i < len; ++i) {
    int max = 0;
    for (int j = startIndex; j <= i + k; ++j) {
        if (max < array[j] - '0') {
            max = array[j] - '0';
            startIndex = j + 1;                    
        }    
    }
}
```

### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.04ms, 71.5MB
- 최대 : 171.18ms, 91.9MB

## [구명 보트](https://school.programmers.co.kr/learn/courses/30/lessons/42885)

### 소요 시간
- 20분

### 간단 풀이 방법
- 주어진 사람의 무게를 오름차순으로 정렬
- 최소, 최대 index를 구한 후, min index가 max index를 초과할 때 까지 순회한다
- 순회 시, 구명보트에 people[min] + people[max] <= limit 라면 answer++

### pseudo code
```java
while (minIndex <= maxIndex) {
    if (people[minIndex] + people[maxIndex] <= limit) {
        minIndex++;
    }
    answer++;
    maxIndex--;
}
```

### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.35ms, 70MB
- 최대 : 12.49ms, 78.3MB

## [섬 연결하기](https://school.programmers.co.kr/learn/courses/30/lessons/42861)

### 소요 시간
- 1시간

### 간단 풀이 방법
- 주어진 costs에서 건설비용 기준으로 오름차순으로 정렬
- costs를 순회하면서, costs[0], costs[1] 노드의 최상단 부모 노드를 찾고, 그 노드 같지 않는다면, 연결한다.
- 연결하는 것 자체가 같은 부모 밑의 노드로 만들기 때문에 answer++

### pseudo code
```java
for (int i = 0; i < costs.length; ++i) {
    if (find(costs[i][0]) != find(costs[i][1])) {
        unite(costs[i][0], costs[i][1]);
        answer += costs[i][2];
    }
}
```

### 시간 복잡도
- O(nlogn)

### 실행 시간 및 메모리
- 최소 : 0.49ms, 70.1MB
- 최대 : 0.85ms, 89.9MB

## [단속 카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884)

### 소요 시간
- 15분

### 간단 풀이 방법
- 각 차량을 진출 지점 기준으로 정렬
- 차량들을 순회하면서, 진입 지점이 max 값 보다 크다면 갱신
- 갱신 시, answer++

### pseudo code
```java
for (int[] route : routes) {
    int start = route[0];
    int end = route[1];
    
    if (start > max) {
        max = end;
        answer++;
    }
}
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 0.54ms, 54.1MB
- 최대 : 6.05ms, 90.6MB