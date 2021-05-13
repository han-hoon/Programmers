package level1.positiveNumver_negativeNumber_plus;

/**
 * @package : sol
 * @class : Solution.java
 * @category : 월간 코드 챌린지 시즌2 Level 1
 * @title : 음양 더하기
 * @date : 2021-05-11 오후 2:41
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/76501
*/
class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i < signs.length; i++) {
            if(signs[i]) answer += absolutes[i];
            else answer -= absolutes[i];
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] absolutes = {4, 7, 12};
        boolean[] signs = {true, false, true};

        System.out.println(new Solution().solution(absolutes, signs));
    }
}