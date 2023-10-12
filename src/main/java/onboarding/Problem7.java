package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    static Map<String, List<String>> friendsAndMutualFriends; // 친구와, 함께 아는 친구
    static Map<String, Integer> friendsAndCommendScore; // 친구와, 추천 점수
    static List<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsAndMutualFriends = new HashMap<>();
        friendsAndCommendScore = new HashMap<>();
        userFriends = new ArrayList<>();

        isUser(user, friends);
        validUserId(user, friends);
        validListSize(friends, visitors);

        return userFriends;
    }

    // User 제외
    public static void isUser(String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);

            if (friend1.equals(user)) {
                userFriends.add(friend2);
            } else if (friend2.equals(user)) {
                userFriends.add(friend1);
            }
        }
    }

    // 아이디 길이, 소문자 검사
    public static void validUserId (String user, List<List<String>> friends) {
        for (List<String> friend : friends) {
            String friend1 = friend.get(0);
            String friend2 = friend.get(1);
            String[] UserIds = {user, friend1, friend2};

            for (String UserId : UserIds) {
                if(!(Pattern.compile("^[a-z]*$").matcher(UserId).matches() && (UserId.length() >= 1 && UserId.length() <= 30))) {
                    throw new IllegalArgumentException("사용자 아이디는 1 이상 30 이하의 소문자여야 합니다.");
                }
            }
        }
    }

    // 친구리스트, 방문자리스트 길이 검사
    public static void validListSize (List<List<String>> friends, List<String> visitors) {
        if(!(friends.size() >= 1 && friends.size() <= 10) || !(visitors.size() >= 1 && visitors.size() <= 10000))
            throw new IllegalArgumentException("친구리스트와 방문자리스트는 1이상 10000이하까지만 가능합니다.");
    }



}