import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=0; i<k; i++) {
            String[] input = br.readLine().split(" ");
            int c1 = Integer.parseInt(input[0]);
            int c2 = Integer.parseInt(input[1]);
            list.get(c1).add(c2);
            list.get(c2).add(c1);
        }

        int count = 0;
        boolean[] isVisit = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        isVisit[1] = true;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next : list.get(cur)) {
                if(isVisit[next]) continue;
                q.add(next);
                isVisit[next] = true;
                count++;
            }
        }
        System.out.println(count);
    }
}
