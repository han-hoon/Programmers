package level3.disk_controller;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package : level3.disk_controller
 * @class : Solution.java
 * @category : 힙(Heap) Level 3
 * @title : 디스크 컨트롤러
 * @date : 2021-05-13 오후 4:32
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42627
*/
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int i,j;
        int runtime = 0;
        int index = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        runtime = jobs[0][0];
        for(i = 0; i < jobs.length; i++) {
            for(j = 0; j < jobs.length; j++) {
                if(jobs[j][0] != -1 && jobs[j][0] <= runtime) {
                    if(index == -1) {
                        index = j;
                    }
                    else if(jobs[j][1] < jobs[index][1]) {
                        index = j;
                    }
                }
                if(index == -1 && j == jobs.length-1) {
                    for(int k = 0; k < jobs.length; k++) {
                        if(jobs[k][0] != -1) {
                            runtime = jobs[k][0];
                            j = 0; break;
                        }
                    }
                }
            }
            runtime += jobs[index][1];
            answer += runtime - jobs[index][0];
            jobs[index][0] = -1;
            index = -1;
        }
        return answer/jobs.length;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(new Solution().solution(jobs));
    }
}