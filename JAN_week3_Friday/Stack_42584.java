import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Stack_42584 {
    public int[] solution(int[] prices) {
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for (int price : prices) {
            q.add(price);
        }
        int i = 0;
        while(!q.isEmpty()) {
            int curr = q.poll();
            int second = 0;
            for (int j = i + 1; j < prices.length; ++j) {
                if (prices[j] < curr) {
                    second = j;
                }
            }
            answer.add(second);
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}