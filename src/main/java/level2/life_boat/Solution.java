package level2.life_boat;

import java.util.Arrays;

/**
 * @package : level2.life_boat
 * @class : Solution.java
 * @category : 탐욕법(Greedy)
 * @title : 구명보트
 * @date : 2021-05-13 오후 4:23
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42885
*/
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int maxWeigthPeopleIndex = people.length - 1;
        int minWeigthPeopleIndex = 0;
        Arrays.sort(people);
        for ( ; minWeigthPeopleIndex <= maxWeigthPeopleIndex; maxWeigthPeopleIndex-- ) {
            if(people[maxWeigthPeopleIndex] + people[minWeigthPeopleIndex] <= limit) {
                minWeigthPeopleIndex++;
            }
            answer++;
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(new Solution().solution(people, limit));
    }
}