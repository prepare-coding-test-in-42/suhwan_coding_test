import java.util.*;

public class Hash_1845 {
    public int solution(int[] nums) {
        int answer = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();

        Arrays.stream(nums).forEach(set::add);

        int setSize = set.size();

        return Math.min(setSize, answer);
    }

    public static void main(String[] args) {
        Hash_1845 p = new Hash_1845();

        System.out.println(p.solution(new int[]{3, 1, 2, 3}));
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(p.solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
}