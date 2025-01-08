## H-Index

### 소요 시간
- 10분

### 간단 풀이 방법
- 논문 인용 횟수 배열을 오름차순으로 정렬
- 배열을 순회 하면서, 인용 횟수가 논문의 수 이상일 경우 return  
- 오름차순으로 눈문 인용 횟수를 정렬했기 때문에, (배열 size) - citations[i]를 하게되면 인용된 논문 수를 구할 수 있음

### Pseudo Code
```java
Arrays.sort();

for (int i = 0; i < size; ++i) {
    int q = size - citations[i];

    if (citations[i] >= q) {
        return
    }
}
```

### 메모리 및 시간
- 최대 : 3.08ms, 78.3MB
- 최소 : 0.44ms, 82MB

