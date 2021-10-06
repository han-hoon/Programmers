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
        return devideBalancedBraket("", p);
    }

    private String devideBalancedBraket(String u, String v) {
        if (v == null || "".equals(v)) {
            return "";
        }
        boolean right = true;
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int i = 0;
        for (i = 0; i < v.length(); i++) {
            if (v.charAt(i) == '(') {
                openBracketCount++;
            } else {
                closeBracketCount++;
            }
            if(closeBracketCount > openBracketCount) {
                right = false;
            }
            if (openBracketCount == closeBracketCount) {
                break;
            }
        }
        if(right) {
            return v.substring(0, i + 1)
                    + devideBalancedBraket(u + v.substring(0, i + 1), v.substring(i + 1, v.length()));
        }
        else {
            return "(" + devideBalancedBraket(u + v.substring(0, i + 1), v.substring(i + 1, v.length()))
                     + ")" + changeBracket(v.substring(0, i + 1));
        }
    }

    private String changeBracket(String bracket) {
        String changedBracket = bracket;
        changedBracket = reverseBracket(changedBracket.substring(1, changedBracket.length() - 1));
        return changedBracket;
    }

    private String reverseBracket(String str) {
        String reversedStr = "";
        for(char c : str.toCharArray()) {
            if(c == '(')
                reversedStr += ")";
            else
                reversedStr += "(";
        }
        return reversedStr;
    }
}


class SolutionRunner {
    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";
//        System.out.println(new Solution().solution(p1));
        System.out.println(new Solution().solution(p2));
        System.out.println(new Solution().solution(p3));
    }
}