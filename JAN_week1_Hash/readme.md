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

## 베스트 앨범

### 소요 시간
- 30분

### 간단 풀이 방법
- 장르별, 플레이 합산을 구해 g map에 저장
- 장르별, 고유 번호와 플레이 횟수를 배열로 play map에 저장
- play map을 플레이 횟수 기준으로 오름차순으로 정렬하고, 만약 플레이 횟수가 같다면 고유번호 기준 내림차순으로 정렬
- 장르별 합산 플레이 횟수를 List로 생성 후, 오름차순으로 정렬
- list 순회 하면서, 장르별 최대 플레이 순으로 고유번호 생성

### pseudo code
```java
for (String k : play.keySet()) {
    play.get(k).sort((o1, o2) -> {
        if (o1[1] == o2[1]) {
            return o1[0] - o2[0];
        }
        return o2[1] - o1[1];
    });
}

for (Map.Entry<String, Integer> e : gList) {
    String key = e.getKey();
    List<int[]> l = play.get(key);
    list.add(l.get(0)[0]);
    if (l.size() > 1) {
        list.add(l.get(1)[0]);
    }
}
```

### 시간 복잡도
- 평균 : O(NlogN)

### 실행 시간 및 메모리
- 최소 : 2.95ms, 73.5MB
- 최대 : 4.82ms, 96.8MB