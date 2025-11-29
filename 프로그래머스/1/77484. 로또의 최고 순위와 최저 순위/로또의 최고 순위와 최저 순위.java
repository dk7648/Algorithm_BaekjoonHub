import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Set<Integer> winNumber = new HashSet<>();
        for(int i=0; i<win_nums.length; i++) {
            winNumber.add(win_nums[i]);
        }
        
        int zeroCount = 0;
        int same = 0;
        for(int n : lottos) {
            if(n == 0) zeroCount++;
            else if(winNumber.contains(n)) same++;
        }
        
        int[] result = {6,6,5,4,3,2,1};
        answer[0] = result[same+zeroCount];
        answer[1] = result[same];
        return answer;
    }
}