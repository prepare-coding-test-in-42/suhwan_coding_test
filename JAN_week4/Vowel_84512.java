public class Vowel_84512 {
    static List<String> list;
    static String[] VOWEL = {"A", "E", "I", "O", "U"};
    static int MAX_LENGTH = 5;
    public int solution(String word) {
        list = new ArrayList<>();

        dfs(0, "");

        return list.indexOf(word);
    }

    private void dfs(int depth, String str) {
        list.add(str);
        if (depth == MAX_LENGTH) {
            return;
        }

        for (int i = 0; i < VOWEL.length; ++i) {
            dfs(depth + 1, str + VOWEL[i]);
        }
    }
}