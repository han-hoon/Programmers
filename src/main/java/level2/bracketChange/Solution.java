package level2.bracketChange;

/**
 * @package : level2.bracketChange
 * @class : Solution.java
 * @category : 2020 KAKAO BLIND RECRUITMENT
 * @title : 괄호 변환
 * @date : 2021-09-13 오후 6:27
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/60058
*/
public class Solution {

    public String solution(String p) {

        if(p == null || "".equals(p))
            return "";

        return getDividedBracket(p);
    }

    public String getDividedBracket(String p) {
        String bracket = "";
        String otherBracket = "";

        return divideBracket("", p);
    }

    public String divideBracket(String u, String v) {
        if(v == null || v.length() == 0)
            return "";
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int i = 0;

        for(i = 0; i < v.length(); i++) {
            if(u.charAt(i) == ')') {
                openBracketCount++;
            } else {        // CLOSE_BRACKET
                closeBracketCount++;
                if(openBracketCount == closeBracketCount) {
                    break;
                }  else if(openBracketCount < closeBracketCount) {
                    i = -1;
                    break;
                }
            }
        }
        if(i > 0) {
            return v.substring(0, i + 1) + divideBracket(v.substring(0, v.length()), v.substring(i, v.length()));
        } else {        // -1
            v = "(" + v;
            String p2 = v + u;

            return divideBracket(p);
        }
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";
        System.out.println(new Solution().solution(p1));
        System.out.println(new Solution().solution(p2));
        System.out.println(new Solution().solution(p3));
    }
}