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
        int answer = 100000;
        String answerStr = "";
        String checkStr = "";
        int checkStrLen = 1;
        do {
            String newStr = "";
            int count = 0;
            int i = 0;
            while(i + checkStrLen < s.length()) {
                checkStr = s.substring(i, i + checkStrLen);
                checkStrLen = checkStr.length();
                while(i + checkStrLen <= s.length()
                        && checkStr.equals(s.substring(i, i + checkStrLen))) {
                    i += checkStrLen;
                    count++;
                }
                if(count > 1) {
                    newStr += count + checkStr;
                    count = 0;
                } else {
                    newStr += checkStr;
                    count = 1;
                    i += checkStrLen;
                }
            }
            answer = newStr.length() < answer ? newStr.length() : answer;
            answerStr = newStr;
        } while(checkStrLen++ < s.length() / 2);
        System.out.println(answerStr);
        return answer;
    }

}
