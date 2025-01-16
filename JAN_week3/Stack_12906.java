import java.util.*;

public class Stack_12906 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; ++i) {
            if (i == 0) {
                stack.push(arr[i]);
            } else if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Stack_12906 p = new Stack_12906();

        System.out.println(Arrays.toString(p.solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
        System.out.println(Arrays.toString(p.solution(new int[]{4, 4, 4, 3, 3})));
    }
}