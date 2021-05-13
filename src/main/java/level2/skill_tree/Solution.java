package level2.skill_tree;

import java.util.HashMap;

/**
 * @package : level2.skill_tree
 * @class : Solution.java
 * @category : Summer/Winter Coding(~2018)
 * @title : 스킬트리
 * @date : 2021-05-13 오후 4:27
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/49993
*/
class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<String, Integer> map = new HashMap<>();
        int answer = 0;
        int index_skill = 0;
        int i, j;
        for (i = 0; i < skill.length(); i++) {
            map.put(skill.substring(i, i+1), i);
        }
        for (i = 0; i < skill_trees.length; i++) {
            String[] s = skill_trees[i].split("");
            int[] index = new int[s.length];
            for (j = 0; j < s.length; j++) {
                if(map.containsKey(s[j])) {
                    index[j] = map.get(s[j]) + 1;
                }
                else
                    index[j] = 0;
            }
            for (j = 0; j < s.length; j++) {
                if(index_skill + 1  == index[j]) {
                    index_skill++;
                }
                else if(index_skill + 1  < index[j]) {
                    j += 50;
                    break;
                }

            }
            if(j == s.length)  {
                answer++;
            }
            index_skill = 0;
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(new Solution().solution(skill, skill_trees));
    }
}