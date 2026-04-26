import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        for(int i=0; i<n; i++) {
            if(computers[i][i] == 1) {
                answer++;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                computers[i][i] = 0;
                while(!q.isEmpty()) {
                    int target = q.poll();
                    for(int to=0; to<n; to++) {
                        if(computers[target][to] == 1) {
                            computers[target][to] = 0;
                            computers[to][target] = 0;
                            q.add(to);
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}