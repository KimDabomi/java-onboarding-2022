package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (number < 1 || number > 10000)
            throw new IllegalArgumentException("number는 1이상 10,000이하인 자연수여야 합니다.");

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
