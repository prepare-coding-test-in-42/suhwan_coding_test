import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int max = -30001;
        
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        
        for (int[] route : routes) {
            int start = route[0];
            int end = route[1];
            
            if (start > max) {
                max = end;
                answer++;
            }
        }
        return answer;
    }
}