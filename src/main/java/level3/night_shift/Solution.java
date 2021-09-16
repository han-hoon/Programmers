package level3.night_shift;

import java.util.Arrays;

/**
 * @package : level3.night_shift
 * @class : Solution.java
 * @category :연습문제
 * @title :야근 지수
 * @date : 2021-09-16 오후 10:22
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/12927
*/
public class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        Arrays.sort(works);
        int val = works[works.length / 2];
        int count = 0;
        int index = 0;
        while(count < n) {
            if(works[index] > val) {
                works[index]--;
                count++;
            } else {
                index++;
            }

            if(index == works.length && count != n) {
                index = 0;
                val--;
            }
            if(val == -1) {
                return 0;
            }
        }

        return getNightShiftDegree(works);
    }

    private long getNightShiftDegree(int[] works) {
        long sum = 0;
        for(int work : works) {
            sum += Math.pow(work, 2);
        }
        return sum;
    }

}

class SolutionRunner {
    public static void main(String[] args) {

        Solution solution = new Solution();

        int n1 = 4;
        int n2 = 1;
        int n3 = 3;
        int[] works1 = {4, 3, 3};
        int[] works2 = {2, 1, 2};
        int[] works3 = {1, 1};
        System.out.println("sol1 : " + solution.solution(n1, works1));
        System.out.println("sol2 : " + solution.solution(n2, works2));
        System.out.println("sol3 : " + solution.solution(n3, works3));
    }
}
