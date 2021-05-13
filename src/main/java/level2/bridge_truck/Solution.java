package level2.bridge_truck;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @package : level2.bridge_truck
 * @class : Solution.java
 * @category : 스택/큐
 * @title : 다리를 지나는 트럭
 * @date : 2021-05-13 오후 4:10
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42583
*/
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; int sum = 0, i = 0; int pass = 0, index = 0;
        Queue<Integer> que = new LinkedList<>();
        int[] time = new int[truck_weights.length];
        for(int a : truck_weights)
            que.add(a);
        for(i = 0; i < truck_weights.length; i++)
            time[i] = -1;
        for(i = 0; true; i++) {
            answer++;
            if(que.size() >0) {
                if((sum + que.peek()) <= weight) {
                    sum += que.poll();
                    time[index] = bridge_length;
                    index++;
                }
            }

            for(int j = pass; j <= index-1; j++)  {

                if(time[j] > 0) {
                    time[j]--;
                }
                if(time[j] == 0) {
                    sum -= truck_weights[j];
                    pass++;
                }
            }
            if(pass == truck_weights.length)
                break;
        }
        answer++;
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7, 4, 5, 6};
        
        System.out.println(new Solution().solution(bridge_length, weight, truck_weights));
    }
}