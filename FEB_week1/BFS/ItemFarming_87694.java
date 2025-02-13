import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int answer;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static boolean[][] visited = new boolean[101][101];
    
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
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        answer = Integer.MAX_VALUE;
        for (int i = 0; i < rectangle.length; ++i) {
            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;
            
            fill(y1, y2, x1, x2);
        }
        // for (int i = 20; i >= 0; i--) {
        //     for (int j = 0; j < 22; ++j) {
        //         System.out.printf("%d ", map[i][j]);
        //     }
        //     System.out.println();
        // }
        bfs(new Pos(characterY * 2, characterX * 2, 0), new Pos(itemY * 2, itemX * 2, 0));
        return answer;
    }
    
    private void fill(int y1, int y2, int x1, int x2) {
        for(int i = y1; i <= y2; i++){
            for(int j = x1; j <= x2; j++){
            	if(map[i][j] == 1) {
                    continue;
                }
                map[i][j] = 1;
                if(i == y1 || i == y2 || j == x1 || j == x2)
                    map[i][j] = 2;
            }
        }
    }
    
    private void bfs(Pos character, Pos item) {
        visited[character.y][character.x] = true;
        
        Queue<Pos> q = new LinkedList<>();
        q.add(character);
        
        while(!q.isEmpty()) {
            Pos curr = q.poll();
            if (curr.y == item.y && curr.x == item.x) {
                answer = (curr.d) / 2;
                return;
            }
            for (int i = 0; i < 4; ++i) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                
                if (ny < 0 || ny >= 101 || nx < 0 || nx >= 101 || map[ny][nx] == 0 || visited[ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == 2) {
                    visited[ny][nx] = true;
                    q.add(new Pos(ny, nx, curr.d + 1));    
                }
                
            }
        }
    }
}