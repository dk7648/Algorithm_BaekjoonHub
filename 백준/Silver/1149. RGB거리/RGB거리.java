import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] cost = new int[n+2][3];
        int[][] dp = new int[n+2][3];
        for(int i=1; i<=n; i++) {
            String[] input = br.readLine().split(" ");
            cost[i][0] = Integer.parseInt(input[0]);
            cost[i][1] = Integer.parseInt(input[1]);
            cost[i][2] = Integer.parseInt(input[2]);
        }

        for(int k=1; k<=n; k++) {
            dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + cost[k][0];
            dp[k][1] = Math.min(dp[k - 1][2], dp[k - 1][0]) + cost[k][1];
            dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + cost[k][2];
        }

        int min = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(min);
    }
}
