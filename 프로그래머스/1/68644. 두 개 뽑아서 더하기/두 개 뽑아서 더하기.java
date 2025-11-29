import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++) {
            for(int k=0; k<numbers.length; k++) {
                if(i == k) continue;
                set.add(numbers[i]+numbers[k]);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        list.addAll(set);
        list.sort((a, b) -> a - b);
        
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}