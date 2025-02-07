class Solution {
    static String t;
    static String[] w;
    static int len;
    static int answer;
    static boolean[] visited;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        t = target;
        w = words;
        
        len = words.length;
        visited = new boolean[len];
        
        boolean flag = false;
        
        for (int i = 0; i < len; ++i) {
            if (words[i].equals(target)) {
                flag = true;
                break ;
            }
        }
        if (!flag) {
            return answer;
        }
        
        dfs(0, begin);
        
        return answer;
    }
    
    private void dfs(int depth, String begin) {
        if (begin.equals(t)) {
            answer = depth;
            return;
        }
        if (depth == len) {
            return;
        }
        
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                if (getDiff(begin, w[i])) {
                    visited[i] = true;
                    dfs(depth + 1, w[i]);
                    visited[i] = false;
                }
            }
        }
        
    }
    
    private boolean getDiff(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
            }
            
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}