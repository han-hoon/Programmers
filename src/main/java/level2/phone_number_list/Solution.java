package level2.phone_number_list;

/**
 * @package : level2.phone_number_list
 * @class : Solution.java
 * @category : 해시 Level 2
 * @title : 전화번호 목록
 * @date : 2021-05-13 오후 3:42
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42577
*/
class Solution {
    public boolean solution(String[] phone_book) {
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book.length; j++) {
                if(j == i || phone_book[i].length() > phone_book[j].length()) continue;
                if(phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) return false;
            }
        }
        return true;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};

        System.out.println(new Solution().solution(phone_book));
    }
}