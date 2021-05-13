package level2.function_develope;

import java.util.LinkedList;
import java.util.Queue;

// TODO : 수정 필요 - 런타임 에러
/**
 * @package : level2_sol.function_develope
 * @class : Solution.java
 * @category : 스택/큐 Level 2
 * @title : 기능개발
 * @date : 2021-05-11 오후 4:37
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42586
*/
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int i =0; int count = 0; int day = 0;
        int[] num = new int[progresses.length];
        int[] result = new int[progresses.length];
        Queue<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[progresses.length];
        for(int a = 0; a < progresses.length; a++)
            check[a] = true;
        while(count != progresses.length) {
            day++;
            for(i = 0; i < progresses.length; i++) {
                if(check[i]) {
                    progresses[i] += speeds[i];
                    if(progresses[i] >= 100) {
                        check[i] = false;
                        num[i] = day;
                        count++;
                    }
                }
            }
        }
        for(i = 0; i < progresses.length-1; i++) {
            int a = num[i];
            if(a > num[i+1]) {
                num[i+1] = a;
            }
            que.add(a);
            if(i == progresses.length-2)
                que.add(num[i+1]);
        }
        count = 0; i = 0;
        while(que.size() > 0) {
            i++; int a = 0;
            a = que.poll();
            if(que.size() > 0) {
                while(true) {
                    if(que.size() == 0)
                        break;
                    if(a == que.peek()) {
                        System.out.println("검사");
                        que.poll();
                        i++;
                    } else
                        break;

                }
                if(i != 0) {
                    result[count++] = i;
                    System.out.println("i : " + i);
                    i=0;
                }
                continue;
            } else {
                result[count] = i;
                break;
            }
        }
        count = 0;
        for(int a : result) {
            if(a != 0) count++;
        }
        int[] answer = new int[count];

        for(i = 0; i <= count; i++) {
            System.out.printf("result : %d\n" , result[i]);
            if(result[i] != 0)
                answer[i] = result[i];
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] progresses = {};
        int[] speeds = {};

        int[] answer = new Solution().solution(progresses, speeds);
        for(int a : answer) {
            System.out.print(a + "\t");
        }
    }
}