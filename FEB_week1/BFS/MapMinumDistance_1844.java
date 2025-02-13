import java.util.*;

class Solution {
    static boolean[][] visited;
    static int answer;
    static int[][] map;
    static int n;
    static int m;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    
    static class Pos {
        int y;
        int x;
        int d;
        public Pos(int y, int x, int d) {
            this.y = y;
            this.x = x;
            this.d = d;
        }
    }
    
    public int solution(int[][] maps) {
        answer = -1;
        n = maps.length;
        m = maps[0].length;
        

        
        map = maps;
        
        visited = new boolean[n][m];
        bfs(new Pos(0, 0, 1));
        return answer;
    }
    
    public void bfs(Pos p) {
        Queue<Pos> q = new LinkedList<>();
        
        q.add(p);
        visited[p.y][p.x] = true;
        
        while (!q.isEmpty()) {
            Pos curr = q.poll();
            
            
            for (int i = 0; i < 4; ++i) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                
                if (ny < 0 || ny >= n || nx < 0 || nx >= m || map[ny][nx] == 0 || visited[ny][nx]) {
                    continue;
                }
                if (ny == n - 1 && nx == m - 1) {
                    answer = curr.d + 1;
                    return ;
                }
                visited[ny][nx] = true;
                q.add(new Pos(ny, nx, curr.d + 1));
            }
            
        }
        
    }
}