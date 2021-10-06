package level1.lotto;

import java.util.Arrays;

/**
 * @package : level1.lotto
 * @class : Solution.java
 * @category :  2021 Dev-Matching: 웹 백엔드 개발자(상반기)
 * @title : 로또의 최고 순위와 최저 순위
 * @date : 2021-09-09 오전 7:40
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/77484
*/
public class Solution {

    public int[] solution(int[] lottos, int[] win_nums) {
        int numZero = 0;
        int score = 0;

        for(int i = 0; i < lottos.length; i++) {
            if(lottos[i] == 0) {
                numZero++;
            } else {
                for(int j = 0; j < win_nums.length; j++) {
                    if(lottos[i] == win_nums[j])
                        score++;
                }
            }
        }
        return new int[]{
                7 - (score + numZero) < 6 ? 7 - (score + numZero) : 6
                , 7 - score < 6 ? 7 - score : 6
        };
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        Arrays.stream(new Solution().solution(lottos, win_nums))
                .forEach(i -> System.out.println(i));
    }
}
