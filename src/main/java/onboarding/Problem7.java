package onboarding;

import java.util.*;
import java.util.regex.Pattern;

public class Problem7 {
    static Map<String, List<String>> friendsAndMutualFriends; // 친구와, 함께 아는 친구
    static Map<String, Integer> friendsAndRecommendScore; // 친구와, 추천 점수
    static List<String> userFriends;

    public static List<String> solution(String user, List<List<String>> friends, List<String> visitors) {
        friendsAndMutualFriends = new HashMap<>();
        friendsAndRecommendScore = new HashMap<>();
        userFriends = new ArrayList<>();

        Exception.isUser(userFriends, user, friends);
        Exception.isValidUserId(user, friends,1 ,30);
        Exception.isValidDoubleListSize(friends, 1, 10);
        recommendFriends(user, friends, visitors);
        checkVisitors(visitors);
        Exception.isValidRecommend(friendsAndRecommendScore);

        List<String> answer = getTopRecommendations();

        return answer;
    }



    // 추천 친구 추가
    public static void recommendFriends(String user, List<List<String>> friends, List<String> visitors) {
        for (List<String> friendPair : friends) {
            String friend1 = friendPair.get(0);
            String friend2 = friendPair.get(1);

            if (userFriends.contains(friend1) && !userFriends.contains(friend2) && !friend2.equals(user)) {
                friendsAndRecommendScore.put(friend2, friendsAndRecommendScore.getOrDefault(friend2, 0) + 10);
            } else if (userFriends.contains(friend2) && !userFriends.contains(friend1) && !friend1.equals(user)) {
                friendsAndRecommendScore.put(friend1, friendsAndRecommendScore.getOrDefault(friend1, 0) + 10);
            }
        }
    }

    // 방문할 때마다 1점씩
    public static void checkVisitors(List<String> visitors) {
        for (String visitor : visitors) {
            friendsAndRecommendScore.put(visitor, friendsAndRecommendScore.getOrDefault(visitor, 0) + 1);
        }
    }

    // 추천점수 높은 사람들 가져와서 정렬
    public static List<String> getTopRecommendations() {
        List<String> sortedRecommendations = new ArrayList<>(friendsAndRecommendScore.keySet());

        sortedRecommendations.removeAll(userFriends); // 내친구는 제외

        sortedRecommendations.sort((user1, user2) -> {
            int score1 = friendsAndRecommendScore.get(user1);
            int score2 = friendsAndRecommendScore.get(user2);

            if (score1 == score2) {
                return user1.compareTo(user2);
            }
            return score2 - score1;
        });

        return sortedRecommendations;
    }

}