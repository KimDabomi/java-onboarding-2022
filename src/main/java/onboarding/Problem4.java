package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] answer = word.toCharArray();
        char[] arrLower = new char[26];
        char[] arrUpper = new char[26];

        for (int i = 0; i < 26; i++) {
            arrLower[i] = (char) ('a' + i);
            arrUpper[i] = (char) ('A' + i);
        }

        Exception.rangeString(word,1,1000);

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
