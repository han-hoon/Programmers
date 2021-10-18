package level2.context_compression;

/**
 * @package : level2.context_compression
 * @class : ContextCompression.java
 * @category : 2020 KAKAO BLIND RECRUITMENT
 * @title : 문자열 압축
 * @date : 2021-10-06 오전 10:37
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/60057
*/
public class ContextCompression {

    public static void main(String[] args) {
        ContextCompression contextCompression = new ContextCompression();
        System.out.println(contextCompression.solution("aabbaccc"));
        System.out.println(contextCompression.solution("ababcdcdababcdcd"));
        System.out.println(contextCompression.solution("abcabcdede"));
        System.out.println(contextCompression.solution("abcabcabcabcdededededede"));
        System.out.println(contextCompression.solution("xababcdcdababcdcd"));
    }

    public int solution(String s) {
        String answer = "";
        int checkStrLen = 1;
        do {
            String checkStr = "";
            String newStr = "";
            int i = 0;
            while(i + checkStrLen < s.length() - 1) {
                int count = 0;
                if("".equals(checkStr)) {
                    checkStr = s.substring(0, checkStrLen);
                } else {
                    checkStr = s.substring(i, i + checkStrLen);
                }
                while(i + checkStrLen <= s.length()
                        && checkStr.equals(s.substring(i, i + checkStrLen))) {
                    i += checkStrLen;
                    count++;
                }
                if(count > 1) {
                    newStr += count + checkStr;
                } else {
                    newStr += checkStr;
                }
            }
            newStr += s.substring(i);
            answer = ("".equals(answer) || newStr.length() < answer.length()) ? newStr : answer;
        } while(checkStrLen++ < s.length());
        return answer.length();
    }
}