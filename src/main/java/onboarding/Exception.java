package onboarding;

import java.util.List;
import java.util.regex.Pattern;

public class Exception {

    public static boolean isException (List<Integer> ListPage) {
        return ListPage.get(0) + 1 != ListPage.get(1);
    }

    public static boolean sizeOfList (List<Integer> ListPage, int size) {
        return ListPage.size() == size;
    }

    public static void rangeNumber (int number, int min_num, int max_num) {
        if (number < min_num || number > max_num)
            throw new IllegalArgumentException(number + "는 " + min_num + " 이상 " + max_num + " 이하인 자연수가 아닙니다.");
    }

    public static void rangeString (String str, int min_len, int max_len) {
        if (str.length() < min_len || str.length() > max_len)
            throw new IllegalArgumentException(str + "의 길이가 " + min_len +" 이상 " + max_len + " 이하가 아닙니다.");

    }

    public static void isValidEmail(String email, String domain, int min_len, int max_len) {
        if (!(email.endsWith(domain) || (email.length() >= min_len && email.length() < max_len)))
            throw new IllegalArgumentException(domain + " 도메인으로만 신청가능합니다. 이메일의 전체 길이는 " + min_len + "자 이상 " + max_len + "자 미만이여야 합니다.");
    }

    public static void isValidCrewSize (List<List<String> > forms, int min_size, int max_size) {
        if (!(forms.size() >= min_size && forms.size() <= max_size))
            throw new IllegalArgumentException("크루는 " + min_size +"명 이상 " + max_size + "명 이하여야 합니다.");
    }

    public static void isValidNickname (String nickname) {
        if (!Pattern.compile("^[가-힣]*$").matcher(nickname).matches())
            throw new IllegalArgumentException("닉네임은 한글만 가능합니다.");
    }

}
