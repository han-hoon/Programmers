package level1.recommendNewId;

/**
 * @package : level1.recommendNewId
 * @class : Solution.java
 * @category : 2021 KAKAO BLIND RECRUITMENT
 * @title : 신규 아이디 추천
 * @date : 2021-09-08 오후 6:31
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/72410?
*/
public class Solution {

    private static final int MAX_ID_LENGTH = 15;
    private static final int MIN_ID_LENGTH = 3;

    public String solution(String new_id) {
        String illegalChars = "[^a-z\\d\\-_.]*";
        String answer = new_id.toLowerCase()
                .replaceAll(illegalChars, "")
                .replaceAll("\\.{2,}", ".");
        answer = removeIllegalPunctuation(answer);
        if(answer.length() == 0) {
            while(answer.length() < MIN_ID_LENGTH)
                answer += answer + "a";
        } else if(answer.length() < MIN_ID_LENGTH) {
            char lastWord = answer.charAt(answer.length()-1);
            while(answer.length() < MIN_ID_LENGTH)
                answer = answer + lastWord;
        } else if(answer.length() > MAX_ID_LENGTH) {
            answer = answer.substring(0, MAX_ID_LENGTH);
        }
        answer = removeIllegalPunctuation(answer);
        return answer;
    }

    private String removeIllegalPunctuation(String str) {
        if(str.startsWith(".")) str = str.substring(1, str.length());
        if(str.endsWith(".")) str = str.substring(0, str.length() - 1);
        return str;
    }

}


class SolutionRunner {
    public static void main(String[] args) {
        System.out.println(new Solution().solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(new Solution().solution("z-+.^."));
        System.out.println(new Solution().solution("=.="));
        System.out.println(new Solution().solution("123_.def"));
        System.out.println(new Solution().solution("abcdefghijklmn.p"));
    }
}