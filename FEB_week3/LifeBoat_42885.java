import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int minIndex = 0;
        int maxIndex = people.length - 1;
        
        while (minIndex <= maxIndex) {
            if (people[minIndex] + people[maxIndex] <= limit) {
                minIndex++;
            }
            answer++;
            maxIndex--;
        }
        return answer;
    }
}