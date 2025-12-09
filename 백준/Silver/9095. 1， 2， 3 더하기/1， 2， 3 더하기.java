import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            int[] dp = new int[num+3];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;
            for(int k=4; k<num+1; k++) {
                dp[k] = dp[k-1] + dp[k-2] + dp[k-3];
            }
            System.out.println(dp[num]);
        }
    }
}
