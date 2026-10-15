package programmers.coding.test;

import java.util.HashSet;
import java.util.Set;

public class SpoilerPrevent {
    public static int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        String[] words = message.split(" ");

        Set<String> normal_words = new HashSet<>(); // 스포일러 구간과 겹치지 않는 단어
        boolean[] is_spoiler = new boolean[words.length]; // i번째 단어가 스포일러 구간과 겹치는지
        int[] word_start = new int[words.length];
        int[] word_end = new int[words.length];

        // 1. 단어별 위치 계산 (끝 인덱스 포함)
        int pos = 0;
        for (int i = 0; i < words.length; i++) {
            word_start[i] = pos;
            word_end[i] = pos + words[i].length() - 1;
            pos += words[i].length() + 1; // 단어 길이 + 공백 1칸
        }

        // 2. 단어별로 스포일러 구간과 겹치는지 분류
        for (int i = 0; i < words.length; i++) {
            for (int[] range : spoiler_ranges) {
                if (word_start[i] <= range[1] && word_end[i] >= range[0]) {
                    is_spoiler[i] = true;
                    break;
                }
            }
            if (!is_spoiler[i]) normal_words.add(words[i]);
        }

        // 3. 왼쪽 단어부터 판정 (일반 단어 Set에 이미 공개된 단어도 함께 넣어 중복 제거)
        for (int i = 0; i < words.length; i++) {
            if (is_spoiler[i] && !normal_words.contains(words[i])) {
                answer++;
                normal_words.add(words[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println(solution("here is muzi here is a secret message"
                , new int[][]{{0, 3}, {23, 28}})); // 1

        // Test Case 2
        System.out.println(solution("my phone number is 01012345678 and may i have your phone number"
                , new int[][]{{5, 5}, {25, 28}, {34, 40}, {53, 59}})); // 4

        // Test Case 3: 단어 하나, 전체가 스포일러
        System.out.println(solution("a", new int[][]{{0, 0}})); // 1

        // Test Case 4: 같은 단어가 서로 다른 스포일러 구간에 두 번 (이미 공개된 단어는 제외)
        System.out.println(solution("a b a", new int[][]{{0, 0}, {4, 4}})); // 1

        // Test Case 5: 구간이 단어 일부만 가림
        System.out.println(solution("hello world", new int[][]{{2, 3}})); // 1

        // Test Case 6: 구간이 공백을 포함해 두 단어에 걸침
        System.out.println(solution("ab cd ef", new int[][]{{1, 4}})); // 2

        // Test Case 7: 일반 구간 단어가 스포일러 단어를 부분 문자열로만 포함 (단어가 같은 건 아님)
        System.out.println(solution("cat concat", new int[][]{{0, 2}})); // 1

        // Test Case 8: 스포일러 단어가 일반 구간 단어의 일부일 때 (역방향 부분 문자열)
        System.out.println(solution("concat cat", new int[][]{{0, 5}})); // 1

        // Test Case 9: 한 구간 안에 같은 단어가 두 번
        System.out.println(solution("a a b", new int[][]{{0, 2}})); // 1

        // Test Case 10: 한 단어가 두 구간에 걸쳐 가려짐
        System.out.println(solution("abc d", new int[][]{{0, 0}, {2, 2}})); // 1

        // Test Case 11: 단어 일부만 가렸고 같은 단어가 일반 구간에 있음
        System.out.println(solution("ab ab", new int[][]{{0, 0}})); // 0

        // Test Case 12: 한 구간 안에서 일부 단어만 일반 구간에 등장
        System.out.println(solution("a b c a", new int[][]{{0, 4}})); // 2

        // Test Case 13: 모든 단어가 스포일러, 중복 단어 존재
        System.out.println(solution("ab ab", new int[][]{{0, 0}, {3, 3}})); // 1

        // Test Case 14: 숫자 단어
        System.out.println(solution("1 11 1", new int[][]{{2, 3}})); // 1

        // Test Case 15: 일반 구간 단어가 스포일러 단어를 접두/접미로 포함
        System.out.println(solution("ab abc cab", new int[][]{{0, 1}})); // 1
    }
}
