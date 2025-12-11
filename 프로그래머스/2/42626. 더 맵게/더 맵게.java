import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a-b);
        for(int s : scoville) {
            pq.add(s);
        }
        while(pq.peek() < K) {
            if(pq.size() < 2) {
                answer = -1;
                break;
            }
            int food1 = pq.poll();
            int food2 = pq.poll();
            int result = food1 + food2*2;
            pq.add(result);
            answer++;
        }
        return answer;
    }
}