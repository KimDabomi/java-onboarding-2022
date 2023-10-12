package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxPobi = maxScore(pobi);
        int maxCrong = maxScore(crong);

        if (maxPobi == maxCrong)
            answer = 0;
        else if (maxPobi > maxCrong)
            answer = 1;
        else
            answer = 2;


        if (isException(pobi) || isException(crong)) {
            System.out.println("페이지는 연속해야 합니다.");
            answer = -1;
        }

        if (!(RightLength(pobi) && RightLength(crong))) {
            System.out.println("페이지의 개수는 2개여야 합니다.");
            answer = -1;
        }

        return answer;
    }

    public static boolean isException (List<Integer> ListPage) {
        return ListPage.get(0) + 1 != ListPage.get(1);
    }

    public static boolean RightLength (List<Integer> ListPage) {
        return ListPage.size() == 2;
    }

    public static int getScore (int page) {
        int[] arrDigits = Stream.of(String.valueOf(page).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = 0;
        int time = 1;
        for (int i = 0; i < arrDigits.length; i++) {
            sum += arrDigits[i];
            time *= arrDigits[i];
        }

        return Math.max(sum, time);
    }

    public static int maxScore (List<Integer> pages) {
        int leftScore = getScore(pages.get(0));
        int rightScore = getScore(pages.get(1));
        return Math.max(leftScore, rightScore);
    }
}