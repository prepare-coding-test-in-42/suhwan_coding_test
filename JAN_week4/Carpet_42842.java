import java.util.*;

public class Carpet_42842 {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        List<Integer> result = new ArrayList<>();
        for (int i = 3; i < area; ++i) {
            int row = area / i;

            if (row >= i) {
                if ((row - 2) * (i - 2) == yellow) {
                    result.add(row);
                    result.add(i);
                    break ;
                }
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}