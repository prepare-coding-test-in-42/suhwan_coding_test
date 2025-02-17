class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        
        int len = number.length() - k;
        
        char[] array = number.toCharArray();
        
        int startIndex = 0;
        
        for (int i = 0; i < len; ++i) {
            int max = 0;
            for (int j = startIndex; j <= i + k; ++j) {
                if (max < array[j] - '0') {
                    max = array[j] - '0';
                    startIndex = j + 1;                    
                }    
            }
            answer.append(max);
        }
        return answer.toString();
    }
}