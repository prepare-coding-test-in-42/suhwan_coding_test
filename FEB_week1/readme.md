## [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165)

### 소요시간
- 15분

### 간단 풀이 방법
- 모든 연산자 조합을 구해 연산을 하여, target과 같다면 print
- 처음에는 모든 연산 조합을 구한 후, 계산 했지만 dfs하면서 계산 결과를 return 하도록 수정

### psuedo code
```
Function solution(numbers, target):
    Return dfs(numbers, target, 0, 0)

Function dfs(numbers, target, depth, sum):
    If depth == length of numbers:
        If sum == target:
            Return 1
        Else:
            Return 0

    Return dfs(numbers, target, depth + 1, sum + numbers[depth]) +
           dfs(numbers, target, depth + 1, sum - numbers[depth])
```
### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.19ms, 78.2MB
- 최대 : 5.62ms, 90MB

