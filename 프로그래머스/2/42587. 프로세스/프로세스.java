import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        //우선순위, 대기시간, 처음인덱스
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);        
        Queue<int[]> q = new LinkedList<>();
        
        int i=0;
        for(int priority : priorities) {
            pq.add(priority);
            q.add(new int[]{priority, i++});
        }

        int order = 1;
        
        while(!q.isEmpty()) {
            int[] target;
            while((target = q.poll())[0] != pq.peek()) {
                q.add(target);
            }
            pq.poll();
            if(target[1] == location) break;
            order++;
        }
        return order;
    }
}