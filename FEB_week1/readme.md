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

## [맵 최단 거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844)

### 소요 시간
- 5분

### 간단 풀이 방법
- bfs를 활용해, 가장 최단 거리를 구한다

### pseudo code
```
FUNCTION solution(maps):
    INITIALIZE answer = -1
    SET n = number of rows in maps
    SET m = number of columns in maps

    SET map = maps
    INITIALIZE visited as a 2D boolean array of size (n, m)

    CALL bfs with starting position (0, 0) and distance 1

    RETURN answer

FUNCTION bfs(p):
    INITIALIZE queue q
    ADD p to q
    MARK p as visited

    WHILE q is not empty:
        POP curr from q

        FOR each direction (up, down, left, right):
            COMPUTE ny, nx as next position

            IF ny, nx is out of bounds OR map[ny][nx] is 0 OR visited[ny][nx] is true:
                CONTINUE to next iteration

            IF ny, nx is the bottom-right corner (n-1, m-1):
                SET answer = curr.d + 1
                RETURN

            MARK ny, nx as visited
            ADD (ny, nx, curr.d + 1) to q
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 0.34ms, 72.5MB
- 최대 : 8.93ms, 90.6MB

## [단어 변환](https://school.programmers.co.kr/learn/courses/30/lessons/43163)

### 소요시간
- 15분

### 간단 풀이 방법
- dfs로 모든 경우의 수를 구하고, 만약 비교할 단어와 현재 단어의 차이나는 글자수가 1일 때만, 조합을 구함

### pseudo code
```
FUNCTION solution(begin, target, words):
    INITIALIZE answer = 0
    SET t = target
    SET w = words
    SET len = length of words
    INITIALIZE visited as a boolean array of size len

    SET flag = false
    FOR i = 0 to len - 1:
        IF words[i] is equal to target:
            SET flag = true
            BREAK

    IF flag is false:
        RETURN answer

    CALL dfs(0, begin)

    RETURN answer

FUNCTION dfs(depth, begin):
    IF begin is equal to target:
        SET answer = depth
        RETURN

    IF depth is equal to len:
        RETURN

    FOR i = 0 to len - 1:
        IF visited[i] is false:
            IF getDiff(begin, words[i]) is true:
                SET visited[i] = true
                CALL dfs(depth + 1, words[i])
                SET visited[i] = false

FUNCTION getDiff(s1, s2):
    INITIALIZE diff = 0
    FOR i = 0 to length of s1 - 1:
        IF s1[i] is not equal to s2[i]:
            INCREMENT diff

        IF diff is greater than 1:
            RETURN false

    RETURN diff is equal to 1
```

### 시간 복잡도
- O(N)

### 실행 시간 및 메모리
- 최소 : 0.02ms, 75.5MB
- 최대 : 0.14ms, 89.3MB

## [아이템 파밍](https://school.programmers.co.kr/learn/courses/30/lessons/87694)

### 소요 시간
- 1시간

### 간단 풀이 방법
- 각 사각형을 이차원 배열에 그린다. 이때 겹치는 격자에 대해서 판별해야하기에 맵과 사각형의 크기를 2배로 지정해서 실행
- 시작점 부터 bfs를 통해서, 아이템 까지의 최단 거리를 구한다

### pseudo code
```
FUNCTION solution(rectangle, characterX, characterY, itemX, itemY):
    INITIALIZE answer as the maximum integer value
    FOR each rectangle in rectangle:
        SCALE the coordinates by multiplying by 2
        CALL fill function with scaled coordinates
    
    CALL bfs with starting position of character and target position of item
    RETURN answer

FUNCTION fill(y1, y2, x1, x2):
    FOR each row from y1 to y2:
        FOR each column from x1 to x2:
            IF map at (i, j) is 1, CONTINUE to next iteration
            SET map[i][j] to 1
            IF i is at the boundary or j is at the boundary, SET map[i][j] to 2

FUNCTION bfs(character, item):
    MARK the starting position (character's position) as visited
    INITIALIZE a queue q
    ADD the character's position to the queue
    
    WHILE q is not empty:
        POP the current position (curr) from the queue
        IF curr is at the target position (item), SET answer to the distance (curr.d) divided by 2, RETURN
        FOR each direction (up, down, left, right):
            COMPUTE new position (ny, nx) from curr position
            IF new position is out of bounds OR visited OR not a valid space (map[ny][nx] == 0), CONTINUE to next iteration
            IF new position is part of the boundary (map[ny][nx] == 2), MARK as visited and ADD to queue with incremented distance
```

### 시간 복잡도
- O(101^2)

### 실행 시간 및 메모리
- 최소 : 0.30ms 69.3MB
- 최대 : 20.98ms, 93.1MB


## [여행 경로](https://school.programmers.co.kr/learn/courses/30/lessons/43164)

### 소요 시간
- 30분

### 간단 풀이 방법
- ICN 부터 시작하여, 갈수 있는 경로를 dfs로 구한다
- 많은 경우의 수가 나오지만, 그 중 알파벳 순서가 빠른 순으로 정렬 후 split하고 return

### pseudo code
```
FUNCTION solution(tickets):
    SET t as tickets
    SET len as length of tickets
    INITIALIZE visited array of size len with false
    INITIALIZE empty list l
    
    CALL dfs with an empty list

    SORT l based on the first element in each ticket, then by the second element
    
    RETURN the first ticket in the sorted list

FUNCTION dfs(list):
    IF list size is equal to len:
        COPY list to l
        RETURN
    
    FOR each ticket in tickets:
        IF ticket is not visited:
            IF list is empty OR last ticket in list's destination matches current ticket's start:
                MARK ticket as visited
                ADD ticket to list
                CALL dfs with updated list
                REMOVE last ticket from list
                UNMARK ticket as visited

FUNCTION isStart(ticket1, ticket2):
    RETURN TRUE if ticket1's destination matches ticket2's start, otherwise FALSE
```

### 시간 복잡도
- O(N!)

### 실행 시간 및 메모리
- 최소 : 10.54ms, 79.4MB
- 최대 : 105.84ms, 112MB