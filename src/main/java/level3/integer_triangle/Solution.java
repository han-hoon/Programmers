package level3.integer_triangle;

import java.util.Arrays;

/**
 * @package : level3.integer_triangle
 * @class : Solution.java
 * @category : 동적계획법 Level 3
 * @title : 정수삼각형
 * @date : 2021-05-11 오후 11:37
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/43105
 */
class Solution {
    public int solution(int[][] triangle) {
        // 배열 초기화
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        // 동적계획법 적용
        for(int i = 1; i < triangle.length; i++) {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
            dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];
        }

        for(int i = 2; i < dp.length; i++) {
            for(int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
            }
        }

        return Arrays.stream(dp[dp.length - 1]).max().getAsInt();
    }
}

class SolutionRunner {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(sol.solution(triangle));
    }

}

