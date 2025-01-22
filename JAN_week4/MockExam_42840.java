public class MockExam_42840 {
    class PersonInfo {
        int index;
        int count;

        public PersonInfo(int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
    int max = -1;
    int[][] gaveUpMath = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        List<PersonInfo> result = getAnswer(answers);
        result.sort((o1, o2) -> {
            if (o2.count == o1.count) {
                return o1.index - o2.index;
            }
            return o2.count - o1.count;
        });
        System.out.println(max);
        return result.stream().filter(p -> p.count == max).mapToInt(p -> p.index).toArray();
    }

    private List<PersonInfo> getAnswer(int[] answer) {
        List<PersonInfo> result = new ArrayList<>();

        int answerLen = answer.length;
        for (int i = 0; i < 3; ++i) {
            int len = gaveUpMath[i].length;
            int count = 0;
            for (int j = 0; j < answerLen; ++j) {
                if (answer[j] == gaveUpMath[i][j % len]) {
                    count++;
                }
            }
            if (count == 0) {
                continue;
            }
            max = Math.max(max, count);
            result.add(new PersonInfo(i + 1, count));
        }
        return result;
    }
