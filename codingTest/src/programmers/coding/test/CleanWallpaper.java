package programmers.coding.test;

import java.util.Arrays;

public class CleanWallpaper {
    public static int[] solution(String[] wallpaper) {
        int luy = wallpaper[0].length(), lux = wallpaper.length;
        int rdy = 0, rdx = 0;

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = Math.min(lux, i);
                luy = Math.min(luy, wallpaper[i].indexOf('#'));
                rdx = Math.max(rdx, i);
                rdy = Math.max(rdy, wallpaper[i].lastIndexOf('#'));
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        // Test Case 1
        System.out.println(Arrays.toString(solution(new String[]{".#...", "..#..", "...#."}))); // [0, 1, 3, 4]

        // Test Case 2
        System.out.println(Arrays.toString(solution(new String[]{"..........", ".....#....", "......##..", "...##.....", "....#....."}))); // [1, 3, 5, 8]

        // Test Case 3
        System.out.println(Arrays.toString(solution(new String[]{".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}))); // [0, 0, 7, 9]

        // Test Case 4
        System.out.println(Arrays.toString(solution(new String[]{"..", "#."}))); // [1, 0, 2, 1]
    }
}
