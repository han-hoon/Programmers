package level1.sort_string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package : level1_sol.sort_string
 * @class : Soution.java
 * @category : 연습문제 Level 1
 * @title :문자열 내 마음대로 정렬하기
 * @date : 2021-05-11 오후 4:18
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/12915
*/
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String[] sort = new String[strings.length];

        Arrays.sort(strings);

        for (int i = 0; i < strings.length; i++) {
            sort[i] = strings[i].substring(n, n+1) + i;
        }

        Arrays.sort(sort, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.charAt(0)-o2.charAt(0);
            }
        });
        for (int i = 0; i < strings.length; i++) {
            answer[i] = strings[Integer.parseInt(sort[i].substring(1))];
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;

        String[] answer = new Solution().solution(strings, n);
        for(String str : answer) {
            System.out.print(str + "\t");
        }
    }
}