package level1.Kth_number;

import java.util.Arrays;

/**
 * @package : sol
 * @class : Solution.java
 * @category : 정렬  Level 1
 * @title : K번째 수
 * @date : 2021-05-11 오전 11:11
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42748
*/
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; i++) {
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3},{4, 4, 1},{1, 7, 3}};

        int[] answer = new Solution().solution(array, commands);
        for(int a : answer) {
            System.out.print(a + "\t");
        }
    }
}