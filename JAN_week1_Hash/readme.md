## 폰캣몬

### 소요시간
- 15분

### 간단 풀이 방법
- 배열의 요소를 set에 중복 없이 저장
- 최대 구할수 있는 포켓몬 갯수(N / 2) 와 비교하여, min 값을 return

### pseudo code
```java
Arrays.stream(nums).forEach(set::add);
return Math.min(setSize, answer);
```

### 시간 복잡도
- O(1)

### 실행 시간 및 메모리
- 최소 : 0.92ms, 70.2MB
- 최대 : 6.09ms, 89.5MB

## 완주하지 못한 선수

### 소요 시간
- 10분

### 간단 풀이 방벙
- map에 마라톤 참가자 이름과 수를 put
- 마라톤 완료 자를 순회하면서, map의 수를 감소
- map을 순회하면서, 남아있는 참가자를 찾아 return

### pseudo code
```java
for (String p : participant) {
    map.put(p, map.getOrDefault(p, 0) + 1);
}

for (String c : completion) {
    map.put(c, map.get(c) - 1);
}

for (String key : map.keySet()) {
    if (map.get(key) != 0) {
        return key;
    }
}
```

### 시간 복잡도
- 첫 번째 루프: O(N)
- 두 번째 루프: O(M)
- 세 번째 루프: O(N)
- 전체 시간 복잡도: O(N + M)

### 실행 시간 및 메모리
- 최소 : 0.06ms, 72.8MB
- 최대 : 1.19ms, 90.4MB


## 전화번호 목록

### 소요 시간
- 10분

### 간단 풀이 방법
- 전화번호 목록을 순차적으로 순회 하면서, 다름 번호가 현재 번호로 시작하는 지에 판단
- 현재 번호로 시작한다면, false 반환
- 서로의 번호가 유니크 하다면 true 반환

### pseudo code
```java
for (int i = 0; i < size - 1; i++) {
        if (phone_book[i + 1].startsWith(phone_book[i])) {
            return false;
        }
    }
```

### 시간 복잡도
- sort : 평균 [O(nlog(n))], 최악[O(n^2)]
- 루프 : O(N)

### 실행 시간 및 메모리
- 최소 : 0.06ms, 70.6MB
- 최대 : 4.26ms, 89.6MB

## 의상 

### 소요 시간
- 20분

### 간단 풀이 방법
- 옷 종류 별, 갯수를 map을 사용하여 count
- 옷을 선택하지 않는 방식도 있기 때문에, (count + 1) 로 조합의 갯수를 구함
- 모두 착용하지 않는 경우의 수를 -1 하고 return

### pseudo code
```java
for (String k : map.key) {
    answer *= (map.get(k) + 1);
}
```

### 시간 복잡도
- 첫 번째 루프 : O(N)
- 두 번째 루프 : O(M)
- 평균 : O(N + M)

### 실행 시간 및 메모리
- 최소 : 0.05ms, 70.8MB
- 최대 : 0.13ms, 91.8MB
