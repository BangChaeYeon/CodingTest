package programmers.coding.test;

import java.util.Arrays;

public class ScaleOutCnt {
    public static int solution(int[] players, int m, int k) {
        // m = 서버 한도, k = 서버 유지 시간
        int answer = 0;

        int[] servers = new int[players.length]; // 서버 증설 이력
        Arrays.fill(servers, 1); // 기본 서버 대수 1대 설정

        for (int i = 0; i < players.length; i++) {
            if (servers[i] * m <= players[i]) {
                int n = servers[i]; // 서버 증설 대수
                int scaleUpCnt = 0; // 서버 증설 횟수

                // 서버 증설 대수 및 증설 횟수 기록
                while (n * m <= players[i]) {
                    n += 1;
                    scaleUpCnt += 1;
                    answer += 1;
                }

                // 서버 증설 이력 저장
                for (int j = i; j < (Math.min((i + k), players.length)); j++) {
                    servers[j] += scaleUpCnt;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println(solution(
            new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},
            3, 5
        )); // 7

        // Test Case 2
        System.out.println(solution(
            new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0},
            5, 1
        )); // 11

        // Test Case 3
        System.out.println(solution(
            new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            1, 1
        )); // 12
    }
}
