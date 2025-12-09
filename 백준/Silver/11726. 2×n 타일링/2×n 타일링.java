import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+2];

        dp[1] = 1;
        dp[2] = 2;
        for(int k=3; k<=n; k++) {
            dp[k] = (dp[k-2] + dp[k-1]) % 10007;
        }
        System.out.println(dp[n]);
    }
}
