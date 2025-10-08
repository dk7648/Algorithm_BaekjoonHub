import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
           String[] set = br.readLine().split(" ");
           int n = Integer.parseInt(set[0]);
           int start = Integer.parseInt(set[1]);

           int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
           int[][] map = new int[101][101];
           int[] dist = new int[101];
           for(int i=0; i<n; i+=2) {
               int from = input[i];
               int to = input[i+1];
               map[from][to] = 1;
               dist[to] = -1;
           }

           Queue<Integer> q = new LinkedList<>();
           q.offer(start);
           dist[start] = 0;

           while(!q.isEmpty()) {
               int from = q.poll();
               for(int to=1; to<=100; to++) {
                   if(map[from][to] != 1) continue;
                   if(dist[to] > 0) continue;
                   dist[to] = dist[from] + 1;
                   q.offer(to);
               }
           }
           int maxIndex = 0;
           for(int i=1; i<=100; i++) {
               if(dist[maxIndex] <= dist[i]) {
                   maxIndex = i;
               }
           }
           System.out.println("#"+test_case+" "+maxIndex);
        }
    }
}