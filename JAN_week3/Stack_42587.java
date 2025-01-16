import java.util.*;

public class Stack_42587 {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int priority : priorities) {
            pq.add(priority);
        }

        int answer = 1;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; ++i) {
                if (pq.peek() == priorities[i]) {
                    if (i == location) {
                        return answer;
                    }
                    answer++;
                    pq.poll();
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Stack_42587 p = new Stack_42587();

        System.out.println(p.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(p.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
