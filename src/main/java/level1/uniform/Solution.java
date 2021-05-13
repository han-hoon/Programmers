package level1.uniform;

import java.util.HashSet;

/**
 * @package : sol
 * @class : Solution.java
 * @category : 탐욕법(Greedy) Level 1
 * @title : 체육복
 * @date : 2021-05-11 오후 2:31
 * @author : HH
 * @verion : 1.0.0
 * @source :https://programmers.co.kr/learn/courses/30/lessons/42862
*/
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int a : reserve)
            set.add(a);
        for(int i = 0; i < lost.length; i++) {
            if(set.contains(lost[i])){
                set.remove(lost[i]);
                continue;
            }
            if(set.contains(lost[i]-1)) {
                set.remove(lost[i]-1);
                continue;
            }
            else if(set.contains(lost[i]+1)) {
                if(i < lost.length-1 && lost[i+1] == lost[i]+1);
                else {
                    set.remove(lost[i]+1);
                    continue;
                }
            }
            n--;
        }
        return n;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        System.out.println(new Solution().solution(n, lost, reserve));
    }
}