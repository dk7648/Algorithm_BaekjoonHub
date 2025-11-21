import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            for(int i=0; i<n; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            int[][][] rotatedArr = new int[3][n][n];
            rotatedArr[0] = rotate(arr, n);
            rotatedArr[1] = rotate(rotatedArr[0], n);
            rotatedArr[2] = rotate(rotatedArr[1], n);

            System.out.println("#"+test_case);
            for(int i=0; i<n; i++) {
                for(int j=0; j<3; j++) {
                    for (int k = 0; k < n; k++) {
                        System.out.print(rotatedArr[j][i][k]);
                    }
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
    }
    public static int[][] rotate(int[][] arr, int n) {
        int[][] copy = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                copy[i][k] = arr[i][k];
            }
        }
        for(int i=0; i<n; i++) {
            for(int k=0; k<n; k++) {
                copy[i][k] = arr[n-1-k][i];
            }
        }
        return copy;
    }
}