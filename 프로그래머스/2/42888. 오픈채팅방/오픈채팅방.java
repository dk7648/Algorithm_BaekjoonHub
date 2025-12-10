import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        
        Map<String, String> map = new HashMap<>();
        int count = 0;
        for(String s : record) {
            String[] input = s.split(" ");
            String code = input[0];
            String id = input[1];
            if(!code.equals("Change")) count++;
            if(code.equals("Leave")) continue;
            String nickname = input[2];
            map.put(id, nickname);
        }
        
        int i=0;
        String[] answer = new String[count];
        for(String s : record) {
            String[] input = s.split(" ");
            String code = input[0];
            String id = input[1];
            if(code.equals("Leave")) {
                answer[i++] = map.get(id) + "님이 나갔습니다.";
                continue;
            } else if(code.equals("Enter")) {
                answer[i++] = map.get(id) + "님이 들어왔습니다.";
            }
        }
        return answer;
    }
}