package level3.trip_route;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @package : level3.trip_route
 * @class : Solution.java
 * @category : 깊이/너비 우선 탐색(DFS/BFS)
 * @title : 여행경로
 * @date : 2021-09-09 오전 7:35
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/43164
*/
public class Solution {

    private static final String firstTrip = "ICN";

    public String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length + 1];
        Deque<Integer> routeIndexDeque = new LinkedList<>();

        Arrays.sort(tickets, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        });

        dfs(tickets, routeIndexDeque, 0, firstTrip);

        for(int i = 0; i < answer.length - 2; i++) {
            answer[i] = tickets[routeIndexDeque.pollFirst()][0];
        }
        answer[answer.length -2] = tickets[routeIndexDeque.peekFirst()][0];
        answer[answer.length -1] = tickets[routeIndexDeque.pollFirst()][1];

        return answer;
    }

    private int dfs(String[][] tickets, Deque<Integer> routeIndexDeque
            , int currentIndex, String nextTrip) {
        if (currentIndex == tickets.length) {
            return 0;
        }

        int result = -1;
        for (int i = 0; i < tickets.length; i++) {
            if (!routeIndexDeque.contains(i)) {
                if (nextTrip.equals(tickets[i][0])) {
                    routeIndexDeque.offerLast(i);
                    int hasNextTrip = dfs(tickets, routeIndexDeque, currentIndex + 1, tickets[i][1]);
                    if (hasNextTrip == -1) {
                        routeIndexDeque.pollLast();
                    } else {
                        result = 1;
                    }
                }
            }
        }
        return result;
    }
}

class SolutionRunner {

    public static void main(String[] args) {
//        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}
                 ,{"SFO", "ATL"}, {"ATL", "ICN"},{"ATL","SFO"}};
        Arrays.stream(new Solution().solution(tickets))
                .forEach(i -> System.out.println(i));
    }

}

