package level2.h_index;

import java.util.LinkedList;
import java.util.Collections;

/**
 * @package : level2.h_index
 * @class : Solution.java
 * @category : 정렬 Level 2
 * @title : H-Index
 * @date : 2021-05-13 오후 4:06
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42747
*/

//TODO : 1.0.0 - 효율 개선 필요
class Solution {
    public int solution(int[] citations) {
        int h = 0; int count = 0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int a : citations)
            list.add(a);
        Collections.sort(list);
        h = list.get(list.size()-1);
        while(h > 0) {
            if(list.get(list.size()-1) == 0) {
                return 0;
            }
            for(int j = list.size()-1; j >= 0; j--) {
                if( list.get(j) >= h) {
                    count++;
                }
            }
            if(count >= h) {
                return h;
            }
            else {
                count = 0;
                h--;
            }
        }
        return 0;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(new Solution().solution(citations));
    }
}