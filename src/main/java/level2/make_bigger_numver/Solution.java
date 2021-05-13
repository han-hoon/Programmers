package level2.make_bigger_numver;

/**
 * @package : level2.make_bigger_numver
 * @class : Solution.java
 * @category : 탐용법(Greedy) Level 2
 * @title : 큰 수 만들기
 * @date : 2021-05-13 오후 4:08
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42883
*/
class Solution {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int index = 0;
        int max = -1;
        k = number.length() - k;
        int[] num = new int[number.length()];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(number.substring(i,i+1));
        }
        for (int i = 0; k != 0; i++) {
            if(num[i] > max) {
                index = i;
                max = num[i];
            }
            if(i == num.length - k) {
                i = index;
                answer.append(num[index]);
                k--;
                max = -1;
            }
        }
        return answer.toString();
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String number = "1924";
        int k = 2;

        System.out.println(new Solution().solution(number, k));
    }
}