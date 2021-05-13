package level3.network;

/**
 * @package : level3.network
 * @class : Solution.java
 * @category : 깊이/너비 우선 탐색(DFS/BFS)
 * @title : 네트워크
 * @date : 2021-05-13 오후 4:34
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/43162
*/
class Solution {
    public int solution(int n, int[][] computers) {

        int answer = 0;
        boolean[] check = new boolean[computers.length];

        for (int i = 0; i < n; i++) {
            if(!check[i]) {
                answer++;
                dfs(computers, i, check);
            }
        }

        return answer;
    }

    public void dfs(int[][] computers, int index, boolean[] check) {
        check[index] = true;
        for (int i = 0; i < check.length; i++) {
            if(computers[index][i] ==1 && !check[i]) {
                dfs(computers, i, check);
            }
        }
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(new Solution().solution(n, computers));
    }
}