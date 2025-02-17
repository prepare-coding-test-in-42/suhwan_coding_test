import java.util.*;

class Solution {
    static int[] island;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        island = new int[n];
        
        for (int i = 0; i < n; ++i) {
            island[i] = i;
        } 
        
        Arrays.sort(costs, (o1, o2) -> o1[2] - o2[2]);
        
        for (int i = 0; i < costs.length; ++i) {
            if (find(costs[i][0]) != find(costs[i][1])) {
                unite(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        return answer;
    }

    public int find(int n) {
        if (island[n] == n) {
            return n;
        }
        return find(island[n]);
    }
    
    public void unite(int n1, int n2) {
        int parentNode1 = find(n1);
        int parentNode2 = find(n2);
        
        island[parentNode1] = parentNode2;
    }
}