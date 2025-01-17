import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort_42748 {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();

        for (int[] command : commands) {
            int start = command[0];
            int end = command[1];
            int index = command[2] - 1;
            int len = end - start + 1;
            int[] subArray = new int[len];

            System.arraycopy(array, start - 1, subArray, 0, len);
            Arrays.sort(subArray);
            answer.add(subArray[index]);
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        Sort_42748 p = new Sort_42748();

        System.out.println(Arrays.toString(
                p.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}))
        );
    }
}