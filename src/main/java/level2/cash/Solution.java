package level2.cash;

import java.util.ArrayList;

/**
 * @package : level2.cash
 * @class : Solution.java
 * @category : 2018 KAKAO BLIND RECRUITMENT
 * @title : [1차] 캐시
 * @date : 2021-05-13 오후 4:25
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/17680
*/
public class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> cache = new ArrayList<String>();

        for(int i =0; i < cities.length; i++) {
            if(cacheSize > 0) {
                if(cache.contains(cities[i].toLowerCase())) {
                    answer += 1;	// cache hit
                    cache.remove(cities[i].toLowerCase());
                    cache.add(cities[i].toLowerCase());
                }
                else {
                    answer += 5;	// cache miss
                    if(cache.size() < cacheSize) {
                        cache.add(cities[i].toLowerCase());
                    }
                    else {
                        cache.remove(0);
                        cache.add(cities[i].toLowerCase());
                    }
                }
            }
            else {
                answer += 5;	// cache miss
            }
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(new Solution().solution(cacheSize, cities));
    }
}
