import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n+2];
        int[] dp = new int[n+2];
        for(int i=1; i<=n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = scores[1];
        dp[2] = dp[1] + scores[2];
        for(int k=3; k<=n; k++) {
            dp[k] = Math.max(dp[k-3] + scores[k-1] + scores[k], dp[k-2] + scores[k]);
        }
        System.out.println(dp[n]);
    }
}
