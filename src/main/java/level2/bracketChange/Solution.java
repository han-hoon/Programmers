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
        if (p == null || "".equals(p))
            return "";
        String balancedBracket = "";
        String u = "";
        String v = p;
        do {
            u = devideBalancedBraket(balancedBracket, v);
            if("".equals(u)) {
                u = devideBalancedBraket(balancedBracket, "(" + v);
                if(u.length() != 0) {
                    u += ")";
                    u = reverseBracket(u.substring(1, u.length() - 1));
                    balancedBracket += u;
                    v = p.substring(balancedBracket.length(), p.length());
                }
            } else {
                balancedBracket += u;
                v = p.substring(balancedBracket.length(), p.length());
            }

        } while (balancedBracket.length() != p.length());
        return u;
    }


    private String devideBalancedBraket(String u, String v) {
        if (v == null || "".equals(v)) {
            return "";
        }
        int openBracketCount = 0;
        int closeBracketCount = 0;
        int i = 0;
        for (i = 0; i < v.length() - 1; i++) {
            if (v.charAt(i) == '(') {
                openBracketCount++;
            } else {
                closeBracketCount++;
            }
            if (openBracketCount == closeBracketCount) {
                return v.substring(0, i + 1)
                        + devideBalancedBraket(u + v.substring(0, i + 1), v.substring(i + 1, v.length()));
            } else if (closeBracketCount > openBracketCount) {
                return "";
            }
        }
        return "";
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
//        System.out.println(new Solution().solution(p2));
        System.out.println(new Solution().solution(p3));
    }
}