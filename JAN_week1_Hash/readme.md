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