package programmers.coding.test;

class FlexibleWork {
    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;

        for (int i = 0; i < timelogs.length; i++) {
            int chkSchedule = addTenMin(schedules[i]);

            for (int j = 0; j < timelogs[i].length; j++) {
                if ((startday + j) % 7 == 0 || (startday + j) % 7 == 6) continue;

                if (chkSchedule < timelogs[i][j]) {
                    answer--;
                    break;
                }
            }
        }

        return answer;
    }

    private static int addTenMin(int schedule) {
        int hour = schedule / 100;
        int min = schedule % 100;

        if (min + 10 >= 60) {
            hour++;
            min -= 50;
        } else {
            min += 10;
        }

        return (hour * 100) + min;
    }

    public static void main(String args[]) {
        // Test Case 1
        System.out.println(solution(new int[]{700, 800, 1100},
                new int[][]{
                        {710, 2359, 1050, 700, 650, 631, 659},
                        {800, 801, 805, 800, 759, 810, 809},
                        {1105, 1001, 1002, 600, 1059, 1001, 1100}
                }, 5)); // 3

        // Test Case 2
        System.out.println(solution(new int[]{730, 855, 700, 720},
                new int[][]{
                        {710, 700, 650, 735, 700, 931, 912},
                        {908, 901, 805, 815, 800, 831, 835},
                        {705, 701, 702, 705, 710, 710, 711},
                        {707, 731, 859, 913, 934, 931, 905}
                }, 1)); // 2

        // Test Case 3: 토요일 시작 - 주말(토/일) 이후의 월요일 지각을 놓치지 않는지 (월요일 1000 > 910)
        System.out.println(solution(new int[]{900}, new int[][]{{2359, 2359, 1000, 900, 900, 900, 900}}, 6)); // 0

        // Test Case 4: 일요일 시작 - 일요일/토요일 지각은 무시, 평일은 모두 정상 -> 1
        System.out.println(solution(new int[]{900}, new int[][]{{2359, 910, 910, 910, 910, 910, 2359}}, 7)); // 1

        // Test Case 5: 수요일 시작 - 주말 이후(월/화)에 지각 (j=6 화요일 1111 > 1110) -> 1
        System.out.println(solution(new int[]{1100, 1100, 1100},
                new int[][]{
                        {1100, 1100, 1100, 2359, 2359, 1110, 1100},  // 주말 지각 무시, 월요일 정확히 1110 -> 정상
                        {1111, 1100, 1100, 1100, 1100, 1100, 1100},  // 수요일 지각
                        {1100, 1100, 1100, 2359, 2359, 1100, 1111}   // 화요일 지각
                }, 3)); // 1

        // Test Case 6: 분 올림 (1155 -> 1205, 1150 -> 1200)
        System.out.println(solution(new int[]{1155, 1155, 1150, 1150},
                new int[][]{
                        {1205, 1205, 1205, 1205, 1205, 1205, 1205}, // 경계값 정상
                        {1206, 1100, 1100, 1100, 1100, 1100, 1100}, // 1분 초과
                        {1200, 1200, 1200, 1200, 1200, 1200, 1200}, // 경계값 정상
                        {1201, 1100, 1100, 1100, 1100, 1100, 1100}  // 1분 초과
                }, 1)); // 2

        // Test Case 7: 금요일(마지막 평일)에만 지각, 주말 지각은 무시
        System.out.println(solution(new int[]{700, 700},
                new int[][]{
                        {700, 700, 700, 700, 711, 700, 700},    // 금요일 지각
                        {700, 700, 700, 700, 710, 2359, 2359}   // 금요일 경계값 정상, 주말 지각 무시
                }, 1)); // 1

        // Test Case 8: 전원 정상 / 전원 지각
        System.out.println(solution(new int[]{600, 1100},
                new int[][]{
                        {610, 610, 610, 610, 610, 2359, 2359},
                        {1110, 1110, 1110, 1110, 1110, 2359, 2359}
                }, 1)); // 2
        System.out.println(solution(new int[]{600, 1100},
                new int[][]{
                        {611, 610, 610, 610, 610, 610, 610},
                        {1100, 1100, 1100, 1100, 1111, 1100, 1100}
                }, 1)); // 0

        // Test Case 9: 일찍 출근(스케줄보다 이른 시각)은 정상 처리
        System.out.println(solution(new int[]{1100}, new int[][]{{0, 1, 600, 1000, 1109, 1110, 1110}}, 1)); // 1
    }
}