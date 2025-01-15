import java.util.*;

public class H_Index {
    public int solution(int[] citations) {
        int answer = 0;
        
        int size = citations.length;
        //순차적으로 정렬
        Arrays.sort(citations);

        //특정 인덱스 i부터 citations배열의 길이까지 만큼의 논문이 citations[i]번 만큼 인용
        for (int i = 0; i < size; ++i) {
            int quoteCount = size - i;

            if (citations[i] >= quoteCount) {
                //인용 횟수가 논문의 수 이상일 경우 answer 
                answer = quoteCount;
                break;
            }
        }
        return answer;
    }
}