package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder answer = new StringBuilder(cryptogram);

        for (int i = 0; i < answer.length() - 1; i++) {
            if (answer.charAt(i) == answer.charAt(i + 1)) {
                answer.deleteCharAt(i);
                answer.deleteCharAt(i);
                i = Math.max(0, i - 2);
                if (answer.length() == 2) {
                    answer.deleteCharAt(i);
                    answer.deleteCharAt(i);
                }
            }
        }
        return answer.toString();
    }
}


