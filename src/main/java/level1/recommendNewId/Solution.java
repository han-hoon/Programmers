package level1.recommendNewId;

import java.util.Locale;

/**
 * @package : level1.recommendNewId
 * @class : Solution.java
 * @category : 
 * @title : 
 * @date : 2021-09-08 오후 6:31
 * @author : 
 * @verion : 1.0.0
 * @source : 
*/
public class Solution {

    public String solution(String new_id) {
        String illegalChar = "~\\!\\@#\\$%\\^&\\*()=\\[\\{\\]\\}:\\?,\\<\\>/";
        String answer = new_id.toLowerCase(Locale.ROOT)
                .toString();

        return answer;
    }

}


class SolutionRunner {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
    }
}