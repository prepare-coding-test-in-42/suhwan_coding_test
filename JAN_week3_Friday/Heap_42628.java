import java.util.PriorityQueue;

public class Heap_42628 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> smallQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        PriorityQueue<Integer> largeQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (String operation : operations) {
            String[] splitOp = operation.split(" ");
            String cmd = splitOp[0];
            int num = Integer.parseInt(splitOp[1]);

            if (cmd.equals("I")) {
                smallQueue.add(num);
                largeQueue.add(num);
            }
            if (cmd.equals("D")) {
                if (smallQueue.isEmpty() || largeQueue.isEmpty()) {
                    continue;
                }
                if (num == -1) {
                    int smallValue = smallQueue.poll();
                    largeQueue.remove(smallValue);
                } else {
                    int largeValue = largeQueue.poll();
                    smallQueue.remove(largeValue);
                }
            }
        }

        if (smallQueue.isEmpty() && largeQueue.isEmpty()) {
            return new int[]{0 ,0};
        }

        return new int[]{largeQueue.poll(), smallQueue.poll()};
    }
}