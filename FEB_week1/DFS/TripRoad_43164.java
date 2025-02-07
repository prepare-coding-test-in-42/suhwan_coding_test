import java.util.*;

class Solution {
    static int len;
    static String[][] t;
    static boolean[] visited;
    static List<String> routes;
    
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        t = tickets;
        len = t.length;
        visited = new boolean[len];
        routes = new ArrayList<>();

        dfs(0, "ICN", "ICN");
        routes.sort((o1, o2) -> o1.compareTo(o2));
        answer = routes.get(0).split(",");
        return answer;
    }
    
    private void dfs(int depth, String start, String route) {
        if (depth == len) {
            routes.add(route);
            return ;
        }
        
        for (int i = 0; i < len; ++i) {
            if (!visited[i]) {
                if (start.equals(t[i][0]) && !visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, t[i][1], route + "," + t[i][1]);
                    visited[i] = false;
                }
            }
        }
    }
}