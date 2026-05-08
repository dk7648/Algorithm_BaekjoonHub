import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for(String operation : operations) {
            String[] input = operation.split(" ");
            String op = input[0];
            int value = Integer.parseInt(input[1]);
            
            if(op.equals("I")) {
                tm.put(value, tm.getOrDefault(value, 0) + 1);
            }
            else if(op.equals("D")) {
                if(tm.isEmpty()) continue;
                if(value == -1) {
                    int min = tm.firstKey();
                    if(tm.get(min) == 1) tm.remove(min);
                    else tm.put(min, tm.get(min)-1);
                    
                } else {
                    int max = tm.lastKey();
                    if(tm.get(max) == 1) tm.remove(max);
                    else tm.put(max, tm.get(max)-1);
                }
            }
        }
        
        if(tm.isEmpty()) return answer;
        answer[0] = tm.lastKey();
        answer[1] = tm.firstKey();
        return answer;
    }
}