import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T= Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n+1][n+1];
            arr[1][1] = 1;

            for(int i=2; i<=n; i++) {
                for(int k=1; k<i+1; k++) {
                    arr[i][k] = arr[i-1][k-1] + arr[i-1][k];
                }
            }
            System.out.println("#"+test_case);
            for(int i=1; i<=n; i++) {
                for(int k=1; k<i+1; k++) {
                    System.out.print(arr[i][k]+" ");
                }
                System.out.println();
            }
        }
    }
}