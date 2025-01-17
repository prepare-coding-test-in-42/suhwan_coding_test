import java.util.Arrays;

public class Sort_42746 {
    public String solution(int[] numbers) {
        String[] numberArray = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(numberArray, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if (numberArray[0].equals("0")) {
            return "0";
        }
        return Arrays.stream(numberArray).collect(StringBuilder::new, StringBuilder::append, StringBuilder::append).toString();
    }

    public static void main(String[] args) {
        Sort_42746 p = new Sort_42746();

        System.out.println(p.solution(new int[]{6, 10, 2}));
        System.out.println(p.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
