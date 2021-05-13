package level2.printer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @package : level2.printer
 * @class : Solution.java
 * @category : 스택/큐 Level2
 * @title : 프린터
 * @date : 2021-05-13 오후 3:35
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42587
*/
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0; int index = 0; int i;
        int[] max = new int[priorities.length];
        Queue<Documents> que = new LinkedList<>();
        PriorityQueue<Documents> order = new PriorityQueue<>();
        for(int a : priorities) {
            order.add(new Documents(a, index));
            que.add(new Documents(a, index++));
        }
        for(i =0; i < priorities.length; i++) {
            max[i]=order.poll().priorities;
        }
        for(i = 0; i < max.length; i++) {
            answer++;
            while(true) {
                Documents a = que.poll();
                if(a.priorities != max[i]) {
                    que.add(a);
                }
                else {
                    if(a.location == location)
                        return answer;
                    break;
                }

            }

        }

        return answer;
    }
}

class Documents implements Comparable<Documents>{
    public int priorities;
    public int location;

    Documents(int priorities, int location) {
        this.priorities = priorities;
        this.location = location;
    }

    @Override
    public int compareTo(Documents o) {
        if(this.priorities < o.priorities) {
            return 1;
        }
        else if(this.priorities > o.priorities) {
            return -1;
        }

        else {
            if(this.location > o.location) {
                return 1;
            }
            else if(this.location < o.location) {
                return -1;
            }
            return 0;
        }

    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(new Solution().solution(priorities, location));
    }
}