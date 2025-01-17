import java.util.LinkedList;
import java.util.Queue;

public class Stack_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int sum = 0;
        int curr = 0;

        Queue<Integer> timeQueue = new LinkedList<>();
        Queue<Integer> bridgeQueue = new LinkedList<>();

        while(true) {
            if (!bridgeQueue.isEmpty() && timeQueue.peek() == time) {
                timeQueue.poll();
                sum -= bridgeQueue.poll();
            }

            if (curr < truck_weights.length && sum + truck_weights[curr] <= weight) {
                timeQueue.add(time + bridge_length);
                bridgeQueue.add(truck_weights[curr]);
                sum += truck_weights[curr];
                curr++;
            }

            time++;
            if (timeQueue.isEmpty()) {
                break;
            }
        }

        return time;
    }

    public static void main(String[] args) {
        Stack_42583 p = new Stack_42583();

        System.out.println(p.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(p.solution(100, 100, new int[]{10}));
        System.out.println(p.solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
    }
}