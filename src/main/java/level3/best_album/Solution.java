package level3.best_album;

import java.util.*;

/**
 * @package : level3.best_album
 * @class : Solution.java
 * @category : 해시 Level 3
 * @title : 배스트앨범
 * @date : 2021-05-13 오후 4:44
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42579
*/
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int i, j, k = 0, index = 0;
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Integer> que =
                new PriorityQueue<Integer>(new Comparator<Integer>() {

                    @Override
                    public int compare(Integer o1, Integer o2) {
                        if(plays[o2] == plays[o1]) return 1;
                        return plays[o2]-plays[o1];
                    }
                });
        for(i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });
        for(i = 0; i < list.size(); i++) {

            for(j = 0; j < genres.length; j++) {
                if(genres[j].equals(list.get(i))) {
                    que.add(j);
                }
            }
            while(que.size() > 0 && k < 2) {
                result.add(que.poll());
                k++;
            }
            que.clear();
            k = 0;
        }
        int[] answer = new int[result.size()];
        for(i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        int[] answer = new Solution().solution(genres, plays);
        Arrays.stream(answer).forEach(i->System.out.print(i + "\t"));
    }
}