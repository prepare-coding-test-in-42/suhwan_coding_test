import java.util.*;

public class Hash_42579 {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> g = new HashMap<>();
        Map<String, List<int []>> play = new HashMap<>();

        for (int i = 0; i < genres.length; ++i) {
            g.put(genres[i], g.getOrDefault(genres[i], 0) + plays[i]);
            play.putIfAbsent(genres[i], new ArrayList<>());
            play.get(genres[i]).add(new int[]{i, plays[i]});
        }

        for (String k : play.keySet()) {
            play.get(k).sort((o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o2[1] - o1[1];
            });
        }
        List<Map.Entry<String, Integer>> gList = new ArrayList<>(g.entrySet());
        gList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        List<Integer> list = new ArrayList<>();

        for (Map.Entry<String, Integer> e : gList) {
            String key = e.getKey();
            List<int[]> l = play.get(key);
            list.add(l.get(0)[0]);
            if (l.size() > 1) {
                list.add(l.get(1)[0]);
            }

        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}