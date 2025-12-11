import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (a,b)-> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        Queue<int[]> q = new LinkedList<>();
        for(int[] job : jobs) {
            q.add(job);
        }
        
        int n = q.size();
        int time = 0;
        while(!q.isEmpty()) {
            if(!q.isEmpty() && pq.isEmpty()) {
                if(time<q.peek()[0]) time = q.peek()[0];
            }
            while(!q.isEmpty() && q.peek()[0] <= time) {
                    pq.add(q.poll());
            }
            
            int[] target = pq.poll();
            time += target[1];
            answer += time - target[0];
        }
        while(!pq.isEmpty()) {
            int[] target = pq.poll();
            time += target[1];
            answer += time - target[0];
            System.out.println(answer);
            
        }
        
        answer /= n;
        return answer;
    }
}