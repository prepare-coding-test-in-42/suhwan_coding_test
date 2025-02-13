import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int answer;
    
    public int solution(int n, int[][] computers) {
        answer = 0;
        
        graph = new ArrayList<>();
        int N = computers.length;
        
        
        for (int i = 0; i <= N; ++i) {
            graph.add(new ArrayList<>());
        }
        
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i + 1).add(j + 1);
                }
            }
        }
        
        // for (List<Integer> l : graph) {
        //     System.out.println(l);
        // }
        
        visited = new boolean[N + 1];
        
        for (int i = 1; i <= N; ++i) {
            bfs(i);
        }
        
        return answer;
    }
    
    private void bfs(int node) {
        if (visited[node]) {
            return ;
        }
        
        visited[node] = true;
        answer++;
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            
            for (Integer n : graph.get(curr)) {
                if (visited[n]) {
                    continue;
                }
                visited[n] = true;
                q.add(n);
            }
        }
        // System.out.println(Arrays.toString(visited));
    }
}