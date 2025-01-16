public class Stack_12909 {
    boolean solution(String s) {
        if (s.startsWith(")")) {
            return false;
        }

        int openCount = 0;
        int closeCount = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                openCount++;
            } else {
                closeCount++;
            }

            if (openCount < closeCount) {
                return false;
            }
        }
        return openCount == closeCount;
    }

    public static void main(String[] args) {
        Stack_12909 p = new Stack_12909();

        System.out.println(p.solution("()()"));
        System.out.println(p.solution("(())()"));
        System.out.println(p.solution(")()("));
        System.out.println(p.solution("(()("));
    }
}