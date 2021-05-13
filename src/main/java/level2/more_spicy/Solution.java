package level2.more_spicy;

/**
 * @package : level2.more_spicy
 * @class : Solution.java
 * @category : 힙(Heap) Level 2
 * @title :  더 맵게
 * @date : 2021-05-13 오후 3:25
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42626
*/
import java.util.PriorityQueue;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0; int first, second;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int a : scoville)
            que.add(a);

        while(que.size() > 0) {
            first = que.poll();
            if(first >= K)
                return answer;
            else if(que.size() != 0){
                answer++;
                second = que.poll();
                que.add(first + second*2);
            }
        }
        return -1;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;
        System.out.println(new Solution().solution(scoville, K));
    }
}