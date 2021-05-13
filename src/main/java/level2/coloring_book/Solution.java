package level2.coloring_book;

import java.util.Arrays;

/**
 * @package : level2.coloring_book
 * @class : Solution.java
 * @category : 2017 카카오코드 예선
 * @title : 카카오프렌즈 컬러링북
 * @date : 2021-05-13 오후 3:31
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/1829
*/
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = {0,0};
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] copy = new int[m][n];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                copy[i][j] = picture[i][j];
            }
        }
        for (int i = 0; i < copy.length; i++) {
            for (int j = 0; j < copy[0].length; j++) {
                if(copy[i][j] != 0) {
                    numberOfArea++;
                    int size = searchArea(copy, i, j, copy[i][j]);
                    if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
                }

            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public int searchArea(int[][] copy, int row, int col, int areaNum) {
        if(row == -1  || col == -1 ) {
            return 0;
        }
        if(row == copy.length  || col == copy[0].length ) {
            return 0;
        }

        if(copy[row][col] ==0 || copy[row][col] != areaNum)
            return 0;

        copy[row][col] = 0;
        return 1 + searchArea(copy, row - 1 , col, areaNum) +
                searchArea(copy, row + 1 , col, areaNum) +
                searchArea(copy, row , col - 1, areaNum) +
                searchArea(copy, row , col + 1, areaNum);
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int[] answer = new Solution().solution(m, n, picture);
        Arrays.stream(answer).forEach(i-> System.out.print(i + "\t"));
    }
}
