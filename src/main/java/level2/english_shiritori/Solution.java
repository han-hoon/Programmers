package level2.english_shiritori;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @package : level2.english_shiritori
 * @class : Solution.java
 * @category : Summer/Winter Coding(~2018) Level 2
 * @title : 영어 끝말잇기
 * @date : 2021-05-13 오후 4:20
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/12981
*/
class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<String>();
        int order = 0, index = 0;
        while(true) {
            order++;
            for(int i = 1; i <= n; i ++) {
                if(index == words.length) return new int[] {0,0};
                if(index == 0);
                else if(set.contains(words[index]) || words[index-1].charAt(words[index-1].length()-1) != words[index].charAt(0))
                    return new int[] {i,order};
                set.add(words[index]);
                index++;
            }
        }
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = new Solution().solution(n, words);

        Arrays.stream(answer).forEach(i->System.out.print(i + "\t"));
    }
}