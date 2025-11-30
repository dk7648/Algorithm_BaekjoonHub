import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+3];
        int[] dp = new int[n+3];
        for(int i=1; i<=n; i++) {
            String[] input = br.readLine().split(" ");
            arr[i] = Integer.parseInt(input[2]);
        }

        dp[1] = arr[1];
        dp[2] = arr[2];
        dp[3] = dp[1] + arr[3];
        for(int i=4; i<=n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + arr[i];
        }
        System.out.println(Math.max(dp[n], dp[n-1]));
    }
}
