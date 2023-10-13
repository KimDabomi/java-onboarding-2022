package onboarding;

import java.util.List;

public class Exception {

    public static boolean isException (List<Integer> ListPage) {
        return ListPage.get(0) + 1 != ListPage.get(1);
    }

    public static boolean rightLength (List<Integer> ListPage, int max) {
        return ListPage.size() == max;
    }

    public static void rangeNumber (int number, int min_num, int max_num) {
        if (number < min_num || number > max_num)
            throw new IllegalArgumentException(number + "는 " + min_num + " 이상 " + max_num + " 이하인 자연수가 아닙니다.");
    }

}
