package onboarding;

import java.util.List;

public class Exception {

    public static boolean isException (List<Integer> ListPage) {
        return ListPage.get(0) + 1 != ListPage.get(1);
    }

    public static boolean RightLength (List<Integer> ListPage, int max) {
        return ListPage.size() == max;
    }

}
