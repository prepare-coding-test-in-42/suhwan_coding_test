import java.util.*;

public class Hash_42578 {
    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        for (String k : map.keySet()) {
            answer *= (map.get(k) + 1);
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        Hash_42578 p = new Hash_42578();

        System.out.println(p.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(p.solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
}