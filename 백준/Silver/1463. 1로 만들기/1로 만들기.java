import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[1000001];
        dp[1] = 0;
        
        int len = Integer.parseInt(br.readLine());
        for(int i=2; i<=len; i++) {
            dp[i] = dp[i-1] + 1;
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            if(i % 2 == 0)
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
        }
        

        System.out.println(dp[len]);
    }
}