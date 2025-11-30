import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] pos = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            pos[i][0] = start;
            pos[i][1] = end;
        }
        Arrays.sort(pos, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int dist = 0;
        int prev = -1000000001;
        for(int i=0; i<n; i++) {
            if(pos[i][1] < prev) continue;
            dist += Math.min(pos[i][1] - prev , pos[i][1] - pos[i][0]);
            prev = pos[i][1];
        }
        System.out.println(dist);
    }
}
