import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<Integer>[] g = new ArrayList[n+1];
        for(int i=1; i<=n; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] e : edge) {
            g[e[0]].add(e[1]);
            g[e[1]].add(e[0]);
        }
        
        int max = 0;
        int[] dist = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        dist[1] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : g[cur]) {
                if(dist[next] > 0) continue;
                dist[next] = dist[cur]+1;
                q.add(next);
                max = Math.max(max, dist[next]);
            }
        }
        
        int answer = 0;
        for(int d : dist) {
            if(d == max) answer++;
        }
        return answer;
    }
}