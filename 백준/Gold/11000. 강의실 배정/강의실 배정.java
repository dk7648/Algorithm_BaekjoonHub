import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] lecture = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            lecture[i][0] = Integer.parseInt(input[0]);
            lecture[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(lecture, (o1, o2) ->
                o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]
        );

        Queue<Integer> q = new PriorityQueue<>();
        q.add(lecture[0][1]);
        int max = 0;
        for(int i=1; i<n; i++) {
            while(q.peek() <= lecture[i][0])
                q.poll();
            q.offer(lecture[i][1]);
            max = Math.max(max, q.size());
        }
        System.out.println(max);
    }
}
