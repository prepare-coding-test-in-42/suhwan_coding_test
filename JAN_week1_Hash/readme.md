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