import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];
        int[] log = new int[n+1];
        dp[1] = 0;
        for(int num=2; num<=n; num++) {
            dp[num] = dp[num-1] + 1;
            log[num] = num-1;
            if(num % 3 == 0 && dp[num / 3]+1 < dp[num]) {
                dp[num] = dp[num / 3] + 1;
                log[num] = num/3;
            }
            if(num % 2 == 0 && dp[num / 2]+1 < dp[num]) {
                dp[num] = dp[num / 2] + 1;
                log[num] = num/2;
            }
        }
        System.out.println(dp[n]);

        int idx = n;
        while(idx > 0) {
            System.out.print(idx + " ");
            idx = log[idx];
        }
    }
}
