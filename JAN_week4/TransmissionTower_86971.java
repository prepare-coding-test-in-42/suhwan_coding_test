public class TransmissionTower_86971 {
    int[][] wireArray;

    public int solution(int n, int[][] wires) {
        wireArray = new int[n + 1][n + 1];
        int answer = Integer.MAX_VALUE;

        for (int[] w : wires) {
            int left = w[0];
            int right = w[1];
            wireArray[left][right] = 1;
            wireArray[right][left] = 1;
        }

        for (int[] w : wires) {
            int left = w[0];
            int right = w[1];

            wireArray[left][right] = 0;
            wireArray[right][left] = 0;

            answer = Math.min(answer, bfs(left, n));

            wireArray[left][right] = 1;
            wireArray[right][left] = 1;
        }
        return answer;
    }

    private int bfs(int left, int n) {
        int cnt = 1;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.add(left);

        while(!q.isEmpty()) {
            int curr = q.poll();
            visited[curr] = true;
            for (int i = 1; i < n + 1; ++i) {
                if (wireArray[curr][i] == 1 && !visited[i]) {
                    q.add(i);
                    cnt++;
                }
            }
        }
        return Math.abs(cnt - (n - cnt));
    }

    public static void main(String[] args) {
        TransmissionTower_86971 t = new TransmissionTower_86971();

        System.out.println(t.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}}));
    }
}