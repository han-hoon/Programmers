package level2.open_chatting_room;

import java.util.HashMap;

/**
 * @package : level2_sol.open_chatting_room
 * @class : Solution.java
 * @category : 2019 KAKAO BLIND RECRUITMENT Level 2
 * @title : 오픈 채팅방
 * @date : 2021-05-11 오후 4:39
 * @author : HH
 * @verion : 1.0.0
 * @source : https://programmers.co.kr/learn/courses/30/lessons/42888
*/

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        String[] id = new String[record.length];
        int[] state = new int[record.length];
        int index = 0;

        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            if(s[0].equals("Enter")) {
                state[index] = 1; id[index] = s[1];
                map.put(s[1], s[2]);
                index++;
            }
            else if (s[0].equals("Leave")) {
                state[index] = 0; id[index] = s[1];
                index++;
            }
            else {
                map.put(s[1], s[2]);
            }
        }
        String[] answer = new String[index];
        for (int i = 0; i < index; i++) {
            if(state[i] == 1) {
                answer[i] = map.get(id[i]) + "님이 들어왔습니다.";
            }
            else {
                answer[i] = map.get(id[i]) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}

class SolutionRunner {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answer = new Solution().solution(record);
        for(String str : answer) {
            System.out.print(str + "\t");
        }
    }
}