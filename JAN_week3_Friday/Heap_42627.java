import java.util.PriorityQueue;

public class Heap_42627 {
    public static class Process {
        int requestTime;
        int takeTime;

        public Process(int requestTime, int takeTime) {
            this.requestTime = requestTime;
            this.takeTime = takeTime;
        }
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        int time = 0;
        int jobsSize = jobs.length;

        PriorityQueue<Process> process = new PriorityQueue<>((o1, o2) -> o1.requestTime - o2.requestTime);
        PriorityQueue<Process> memory = new PriorityQueue<>((o1, o2) -> o1.takeTime - o2.takeTime);

        for (int[] job : jobs) {
            process.add(new Process(job[0], job[1]));
        }

        while (!process.isEmpty() || !memory.isEmpty()) {
            while (!process.isEmpty() && process.peek().requestTime <= time) {
                memory.add(process.poll());
            }

            if (memory.isEmpty()) {
                time = process.peek().requestTime;
            } else {
                Process p = memory.poll();
                time += p.takeTime;
                answer += (time - p.requestTime);
            }

        }

        return (answer / jobsSize);
    }


    public static void main(String[] args) {
        Heap_42627 p = new Heap_42627();

        System.out.println(p.solution(new int[][]{{0, 3}, {1, 9}, {3, 5}}));
    }
}