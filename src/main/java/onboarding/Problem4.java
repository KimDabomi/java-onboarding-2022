package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] answer = word.toCharArray();
        char[] arrLower = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] arrUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

        if (word.isEmpty() || word.length() > 1000)
            throw new IllegalArgumentException("word 길이가 1이상 1000이하여야 합니다.");


        for (int j = 0; j < answer.length; j++) {
            if (answer[j] >= 'A' && answer[j] <= 'Z') {
                int index = new String(arrUpper).indexOf(answer[j]);
                answer[j] = arrUpper[25 - index];
            } else if (answer[j] >= 'a' && answer[j] <= 'z') {
                int index = new String(arrLower).indexOf(answer[j]);
                answer[j] = arrLower[25 - index];
            }
        }


        return new String(answer);
    }
}
