import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for(String city : cities) {
            city = city.toUpperCase();
            if(cacheSize == 0) {
                answer += 5;
            } else if(q.contains(city)) {
                q.remove(city);
                q.add(city);
                answer += 1;
            } else if(q.size() == cacheSize) {
                q.poll();
                q.add(city);
                answer += 5;
            } else {
                q.add(city);
                answer += 5;
            }
        }
        return answer;
    }
}