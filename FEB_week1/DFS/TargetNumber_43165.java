import java.util.*;

class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        if (depth == numbers.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(numbers, target, depth + 1, sum + numbers[depth]) +
               dfs(numbers, target, depth + 1, sum - numbers[depth]);
    }
}

/**
1번째 풀이
import java.util.*;

class Solution {
    static List<String> ops;
    static String[] op = {"+", "-"};
    static int len;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        len = numbers.length;
        
        ops = new ArrayList<>();
        
        dfs(0, "");    
        
        for (String s : ops) {
            int sum = 0;
            for (int i = 0; i < len; ++i) {
                if (s.charAt(i) == '+') {
                    sum += numbers[i];
                } else {
                    sum -= numbers[i];
                }
            }
            
            if (sum == target) {
                answer++;
            }
        }
        // System.out.println(ops);
        return answer;
    }
    
    private void dfs(int depth, String str) {
        if (str.length() == len) {
            ops.add(str);
            return ;
        }
        for (String s : op) {
            dfs(depth + 1, str + s);
        }
    }
}
*/