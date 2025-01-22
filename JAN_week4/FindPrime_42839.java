import java.util.HashSet;
import java.util.Set;

public class FindPrime_42839 {
    Set<Integer> set = new HashSet<>();
    boolean visited[] = new boolean[7];

    public int solution(String numbers) {
        int answer = 0;
        dfs(numbers, "", 0);
        for (Integer num : set) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    private void dfs(String num, String curr, int depth) {
        if (depth > num.length()) {
            return;
        }

        for (int i = 0; i < num.length(); ++i) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(curr + num.charAt(i)));
                dfs(num, curr + num.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i < (int)Math.sqrt(num); ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}