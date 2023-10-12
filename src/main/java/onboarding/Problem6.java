package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem6 {
    static Map<String, String> combinedNicknameWithEmail; // 두글자씩 자른 닉네임과 그에 따른 이메일 저장하는 맵
    static Set<String> checkedEmail; // 검사된 이메일을 가져오는 셋

    public static List<String> solution(List<List<String> > forms) {
        combinedNicknameWithEmail = new HashMap<>();
        checkedEmail = new HashSet<>();

        for (List<String> crewForm : forms) {
            String email = crewForm.get(0);
            String nickname = crewForm.get(1);

            if (!validCrewSize(forms))
                throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하여야 합니다.");

            if (!validEmail(email))
                throw new IllegalArgumentException("email.com 도메인으로만 신청가능합니다. 이메일의 전체 길이는 11자 이상 20자 미만이여야 합니다.");

            if (!validNickname(nickname))
                throw new IllegalArgumentException("닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이여야 합니다.");

            checkingNickname(nickname, email);
        }

        List<String> answer = new ArrayList<>(checkedEmail);
        Collections.sort(answer);

        return answer;
    }

    private static void checkingNickname(String nickname, String email) {
        String[] charNicknames = nickname.split(""); // 한 글자씩 쪼개기
        List<String> splitedNicknames = new ArrayList<>(); // 쪼갠 글자 넣을 리스트

        // 쪼갠 글자 리스트에 넣기
        for (String charNickname : charNicknames) {
            splitedNicknames.add(charNickname);
        }

        for (int i = 0; i < splitedNicknames.size() - 1; i++) {
            // 쪼갠 글자들을 두글자씩 잇기
            String combinedNickname = splitedNicknames.get(i) + splitedNicknames.get(i + 1);

            // 두글자씩 이은 닉네임이 해시맵에 키값으로 있으면 이메일을 checkedEmail에 추가
            if (combinedNicknameWithEmail.containsKey(combinedNickname)) {
                checkedEmail.add(email);
                checkedEmail.add(combinedNicknameWithEmail.get(combinedNickname));
            } else {
                // 키값에 없으면 다른 닉네임의 확인을 위해 combinedNicknameWithEmail에 추가
                combinedNicknameWithEmail.put(combinedNickname, email);
            }
        }
    }

    private static boolean validEmail(String email) {
        return email.endsWith("@email.com") && email.length() >= 11 && email.length() < 20;
    }

    private static boolean validCrewSize (List<List<String> > forms) {
        return forms.size() >=1 && forms.size() <= 10000;
    }

    private static boolean validNickname (String nickname) {
        return Pattern.compile("^[가-힣]*$").matcher(nickname).matches() && nickname.length() >= 1 && nickname.length() < 20;
    }

}
