package level3.dual_priority_queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @package : level3.dual_priority_queue
 * @class : Solution.java
 * @category : 힙(Heap)
 * @title : 이중우선순위큐
 * @date : 2021-05-13 오후 4:37
 * @author : HH
 * @verion : 1.0.0
 * @source :https://programmers.co.kr/learn/courses/30/lessons/42628
*/
// TODO : 우선순위 큐의 remove() 메서드 사용시 삭제 대상과 같은 Value를 지닌 모든 요소가 삭제 되어 문제가 생길 수 있음
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> maxOperationQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minOperationQue = new PriorityQueue<>();
        for (String operation : operations) {
            String[] arr = operation.split(" ");
            switch (arr[0]) {
                case "I":
                    maxOperationQue.add(Integer.parseInt(arr[1]));
                    minOperationQue.add(Integer.parseInt(arr[1]));
                    break;
                case "D":
                    int removeValue = 0;
                    if(maxOperationQue.size() > 0) {
                        if(Integer.parseInt(arr[1]) >  0) {
                            removeValue = maxOperationQue.poll();
                            minOperationQue.remove(removeValue);
                        } else {
                            removeValue = minOperationQue.poll();
                            maxOperationQue.remove(removeValue);
                        }
                    }
                    break;
            }
        }

        if(maxOperationQue.size() > 0) {
            int value = maxOperationQue.poll();
            answer[0] = value;
            minOperationQue.remove(value);
            if(minOperationQue.size() > 0) {
                value = minOperationQue.poll();
                answer[1] = value;
            } else {
                answer[1] = 0;
            }
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
//        String[] operations = {"I 16","D 1"};
        String[] operations = {"I 7","I 5","I -5","D -1"};

        int[] answer = new Solution().solution(operations);

        Arrays.stream(answer).forEach(i->System.out.print(i + "\t"));
    }
}