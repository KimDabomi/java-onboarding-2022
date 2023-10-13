package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        Exception.rangeNumber(number,1,10000);

        for (int i = 1; i <= number; i++) {
            int temp = i;
            while (temp > 0) {
                if (temp % 10 != 0 && (temp % 10) % 3 == 0) {
                    answer++;
                }
                temp /= 10;
            }
        }
        return answer;
    }
}
