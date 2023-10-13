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

            Exception.isValidEmail(email,"@email.com", 11, 20);
            Exception.isValidDoubleListSize(forms, 1, 10000);
            Exception.rangeString(nickname, 1, 20);
            Exception.isValidNickname(nickname);

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
}
