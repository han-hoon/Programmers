package level1.movkExam;

import java.util.ArrayList;
import java.util.List;

/**
 * @package : sol
 * @class : Solution.java
 * @category : 완전탐색 Level 1
 * @title : 모의고사
 * @date : 2021-05-11 오후 2:44
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42840
*/
class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<Integer>();
        int[] choice1 = {5,1,2,3,4};
        int[] choice2 = {5,2,1,2,3,2,4,2};
        int[] choice3 = {5,3,3,1,1,2,2,4,4,5};
        int score1 = getScore(answers, choice1);
        int score2 = getScore(answers, choice2);
        int score3 = getScore(answers, choice3);
        int maxScore = 0;
        int[] resultArr = {score1, score2, score3};
        for(int i = 0; i < resultArr.length; i++) {
            if(maxScore < resultArr[i]) maxScore = resultArr[i];
        }
        for(int i = 0; i < resultArr.length; i++) {
            if(resultArr[i] == maxScore) list.add(i + 1);
        }

        return list.stream().mapToInt(i->i).toArray();
    }
    private int getScore(int[] answers, int[] choice) {
        int score = 0;
        for(int i = 1 ; i <= answers.length; i++) {
            if(answers[i-1] == choice[i % choice.length]) score++;
        }
        return score;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] answers = {};

        int[] answer = new Solution().solution(answers);
        for(int a : answer) {
            System.out.print(a + "\t");
        }
    }
}