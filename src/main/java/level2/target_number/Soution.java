package level2.target_number;

/**
 * @package : level2.target_number
 * @class : Soution.java
 * @category : 깊이/너비 우선 탐색(DFS/BFS) Level 2
 * @title : 타겟 넘버
 * @date : 2021-05-13 오후 3:23
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/43165
*/
class Solution {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers, true, target, 0, 0) + dfs(numbers, false, target, 0, 0);
        return answer;
    }

    public int dfs(int[] numbers, boolean sign, int target, int index, int sum) {
        if(sign)
            sum += numbers[index];
        else
            sum -= numbers[index];
        if(index == numbers.length-1) {
            if(sum == target)
                return 1;
            return 0;
        }
        return dfs(numbers, true, target, index + 1, sum) + dfs(numbers, false, target, index + 1, sum);
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        System.out.println(new Solution().solution(numbers, target));


    }
}
