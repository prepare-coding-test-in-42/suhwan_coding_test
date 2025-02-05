public class Dungeon_87946 {
    static boolean[] visited;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];

        dfs(0, k, dungeons);
        return answer;
    }

    private void dfs(int depth, int fatigue, int[][] dungeon) {
        for (int i = 0; i < dungeon.length; ++i) {
            if (visited[i] || dungeon[i][0] > fatigue) {
                continue;
            }
            visited[i] = true;
            dfs(depth + 1, fatigue - dungeon[i][1], dungeon);
            visited[i] = false;
        }
        answer = Math.max(answer, depth);
    }
}