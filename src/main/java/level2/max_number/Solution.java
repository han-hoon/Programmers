package level2.max_number;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @package : level2.max_number
 * @class : Solution.java
 * @category : 정렬 Level2
 * @title : 가장 큰 수
 * @date : 2021-05-13 오후 3:39
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42746
*/
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] tmp = Arrays.toString(numbers).replaceAll("[^0-9 ]","").split(" ");
        PriorityQueue<String> que = new PriorityQueue<String>( new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2+ o1) - Integer.parseInt(o1+ o2);
            }
        });

        for(String a : tmp)
            que.add(a);
        while(que.size() > 0)
            answer += que.poll();

        if(answer.charAt(0) == '0')
            answer = "0";
        return answer;
    }
}

class SolutionRunner{
    public static void main(String[] args) {
        int[] numbers = {6, 10, 2};

        System.out.println(new Solution().solution(numbers));
    }
}
