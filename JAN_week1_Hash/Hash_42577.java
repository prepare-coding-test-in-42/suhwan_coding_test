import java.util.*;

public class Hash_42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Hash_42577 p = new Hash_42577();

        System.out.println(p.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(p.solution(new String[]{"123","456","789"}));
        System.out.println(p.solution(new String[]{"12","123","1235","567","88"}));
    }
}
