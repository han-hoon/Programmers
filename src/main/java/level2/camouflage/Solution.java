package level2.camouflage;

import java.util.HashMap;
import java.util.Set;

/**
 * @package : level2.camouflage
 * @class : Solution.java
 * @category : 해시 Level 2
 * @title : 위장
 * @date : 2021-05-13 오후 3:44
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42578
*/
class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0)+1);
        }
        Set<String> set = map.keySet();
        for(String a : set) {
            answer *= map.get(a)+1;
        }
        return answer-1;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};

        System.out.println(new Solution().solution(clothes));
    }
}