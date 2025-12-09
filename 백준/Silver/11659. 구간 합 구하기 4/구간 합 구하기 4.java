import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N+1];
        input = br.readLine().split(" ");
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        int[] dp = new int[N+1];
        for(int i=1; i<=N; i++) {
            dp[i] = dp[i-1] + arr[i];
        }

        for(int i=0; i<M; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            int result = dp[end] - dp[start-1];
            System.out.println(result);
        }
    }
}
