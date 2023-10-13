package onboarding;

import java.util.List;
import java.util.stream.Stream;


class Problem1 {
    static final int PAGE_SIZE = 2;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if (Exception.isException(pobi) || Exception.isException(crong)) {
            return -1;
        }

        if (!(Exception.sizeOfList(pobi, PAGE_SIZE) && Exception.sizeOfList(crong, PAGE_SIZE))) {
            return -1;
        }

        if (maxScore(pobi) > maxScore(crong))
            answer = 1;
        else if (maxScore(pobi) < maxScore(crong))
            answer = 2;

        return answer;
    }


    public static int getScore (int page) {
        int[] arrDigits = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int multi = 1;
        for (int i = 0; i < arrDigits.length; i++) {
            sum += arrDigits[i];
            multi *= arrDigits[i];
        }

        return Math.max(sum, multi);
    }

    public static int maxScore (List<Integer> pages) {
        int leftScore = getScore(pages.get(0));
        int rightScore = getScore(pages.get(1));
        return Math.max(leftScore, rightScore);
    }
}