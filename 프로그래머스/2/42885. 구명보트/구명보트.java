import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int max = people.length-1;
        int min = 0;
        while(max >= min) {
            if(max == min) {
                answer++;
                break;
            }
            
            if(people[min] + people[max] <= limit) {
                min++;
            }
            answer++;
            max--;
        }
        return answer;
    }
}