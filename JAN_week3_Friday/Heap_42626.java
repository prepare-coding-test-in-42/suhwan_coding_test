import java.util.*;

public class Heap_42626 {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for (int s : scoville) {
            pq.add(s);
        }
        int answer = 0;
        while(!pq.isEmpty()) {
            if (pq.peek() < K) {
                if (pq.size() < 2) {
                    return -1;
                }
                int curr = pq.poll();
                int next = pq.poll();

                int newScoville = curr + (next * 2);
                pq.add(newScoville);
                answer++;
            } else {
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Heap_42626 p = new Heap_42626();

        System.out.println(p.solution(new int[]{3, 2, 1, 9, 10, 12}, 7));
    }
}