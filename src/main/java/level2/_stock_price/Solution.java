package level2._stock_price;

import java.util.Arrays;

/**
 * @package : level2._stock_price
 * @class : Solution.java
 * @category : 스택/큐 Level 2
 * @title : 주식가격
 * @date : 2021-05-13 오후 4:17
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42584
*/
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int turn = 0;
        for(int i =0; i < prices.length; i++) {
            for(int j = i+1; j < prices.length; j++) {
                turn++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }
            answer[i] = turn;
            turn = 0;
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        int[] answer = new Solution().solution(prices);

        Arrays.stream(answer).forEach(i -> System.out.print(i + "\t"));
    }
}