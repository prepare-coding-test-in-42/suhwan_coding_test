import java.util.*;

public class Stack_42586 {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < progresses.length; ++i) {
            q.add((int) Math.ceil((100.0 - progresses[i]) / speeds[i]));
        }

        List<Integer> answer = new ArrayList<>();
        while(!q.isEmpty()) {
            int leftDay = q.poll();
            int count = 1;

            while (!q.isEmpty() && q.peek() <= leftDay) {
                q.poll();
                count++;
            }
            answer.add(count);
        }
        return answer;
    }

    public static void main(String[] args) {
        Stack_42586 p = new Stack_42586();

        System.out.println(p.solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}));
        System.out.println(p.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}));
    }
}