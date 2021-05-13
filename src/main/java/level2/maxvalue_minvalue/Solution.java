package level2.maxvalue_minvalue;

import java.util.Arrays;

/**
 * @package : level2.maxvalue_minvalue
 * @class : Solution.java
 * @category : 연습문제 Level 2
 * @title : 최댓값과 최솟값
 * @date : 2021-05-13 오후 4:29
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/12939
*/
public class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);

        return arr[0] + " " + arr[arr.length-1];
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String s = "1 2 3 4";

        System.out.println(new Solution().solution(s));
    }
}