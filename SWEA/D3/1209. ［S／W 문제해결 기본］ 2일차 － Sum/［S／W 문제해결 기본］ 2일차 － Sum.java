import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=10;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[100][100];
            for(int i=0; i<100; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int max = 0;
            for(int i=0; i<100; i++) {
                int horizontalSum = 0;
                int verticalSum = 0;
                for(int k=0; k<100; k++) {
                    horizontalSum += arr[i][k];
                    verticalSum += arr[k][i];
                }
                max = Math.max(max, horizontalSum);
                max = Math.max(max, verticalSum);
            }

            int sum1 = 0;
            int sum2 = 0;
            for(int i=0; i<100; i++) {
                sum1 += arr[i][i];
                sum2 += arr[99-i][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);

            System.out.println("#"+test_case+" "+max);
        }
    }
}