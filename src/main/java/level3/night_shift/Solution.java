package level3.night_shift;

import java.util.Arrays;
import java.util.Collections;

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
        Integer[] worksWrapped = Arrays.stream(works).boxed().toArray(Integer[]::new);
        Arrays.sort(worksWrapped
                , Collections.reverseOrder());
        int val = worksWrapped[0];
        int count = 0;
        int index = 0;
        while(count < n) {
            if(worksWrapped[index] > val) {
                worksWrapped[index]--;
                count++;
            } else {
                index++;
            }
            if(index == worksWrapped.length && count != n) {
                index = 0;
                val--;
            }
            if(val == -1) {
                return 0;
            }
        }
        Arrays.stream(worksWrapped).forEach(i -> System.out.print(i + "\t"));
        return getNightShiftDegree(worksWrapped);
    }

    private long getNightShiftDegree(Integer[] works) {
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
        int n4 = 99;
        int[] works1 = {4, 3, 3};
        int[] works2 = {2, 1, 2};
        int[] works3 = {1, 1};
        int[] works4 = {2, 15, 22, 55, 55};
        System.out.println("sol1 : " + solution.solution(n1, works1));
        System.out.println("sol2 : " + solution.solution(n2, works2));
        System.out.println("sol3 : " + solution.solution(n3, works3));
        System.out.println("sol4 : " + solution.solution(n4, works4));
    }
}
