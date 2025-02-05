import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MiniRectangle_86491 {
    public int solution(int[][] sizes) {
        List<Integer> maxRow = new ArrayList<>();
        List<Integer> maxCol = new ArrayList<>();

        for (int[] size : sizes) {
            int row = size[0];
            int col = size[1];
            if (row < col) {
                maxRow.add(col);
                maxCol.add(row);
                continue;
            }
            maxRow.add(row);
            maxCol.add(col);
        }

        return Collections.max(maxRow) * Collections.max(maxCol);
    }
}
