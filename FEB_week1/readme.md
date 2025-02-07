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

## [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162)

### 소요 시간
- 20분

### 간단 풀이 방법
- 각 컴퓨터를 노드로 생각하여, 양방향 그래프로 생성
- 각 노드를 순회하면서, 각 연결되어있는 모든 컴퓨터를 방문하면서 체크하고 끝난다면 answer++

### pseudo code
```
Function solution(n, computers):
    answer = 0
    graph = empty adjacency list
    N = length of computers

    // Initialize adjacency list
    For i from 0 to N:
        Add empty list to graph

    // Build the graph based on the computers matrix
    For i from 0 to N:
        For j from 0 to N:
            If i ≠ j and computers[i][j] == 1:
                Add (j + 1) to graph[i + 1]

    visited = boolean array of size (N + 1), all set to false

    // Perform BFS on each node
    For i from 1 to N:
        bfs(i)

    Return answer

Function bfs(node):
    If visited[node] is true:
        Return

    Mark visited[node] as true
    Increment answer

    Create an empty queue q
    Add node to q

    While q is not empty:
        curr = q.poll()

        For each neighbor n in graph[curr]:
            If visited[n] is true:
                Continue
            Mark visited[n] as true
            Add n to q
```

### 시간 복잡도
- O(N^2)

### 실행 시간 및 메모리
- 최소 : 0.10ms, 77.4MB
- 최대 : 0.77ms, 89.1MB