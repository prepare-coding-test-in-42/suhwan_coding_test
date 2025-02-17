import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        int move = len - 1;
        int index;
        
        if ("".equals(name.replace("A", ""))) {
            return 0;
        }
        
        for (int i = 0; i < len; ++i) {
            char c = name.charAt(i);
            if (c != 'A') {
                answer += Math.min(c - 65, 91 - c);
                index = i + 1;
                while (index < len && name.charAt(index) == 'A') {
                    index++;
                }
                //뒤로 갈때 
                move = Math.min(move, i * 2 + len - index);
                // 앞으로 갈때
                move = Math.min(move, (len - index) * 2 + i);
            }
        }
        return answer + move;
    }
}
