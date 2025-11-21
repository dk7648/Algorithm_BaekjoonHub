import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            int d = 0;
            int x= 0;
            int y = 0;
            arr[0][0] = 1;

            while(n != 1) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= n || arr[ny][nx] != 0) {
                    d = (d+1)%4;
                    continue;
                }
                arr[ny][nx] = arr[y][x] + 1;
                if(arr[ny][nx] == n*n) break;
                x = nx;
                y = ny;
            }

            System.out.println("#"+test_case);
            for(int i=0; i<n; i++) {
                for(int k=0; k<n; k++) {
                    System.out.print(arr[i][k] + " ");
                }
                System.out.println();
            }
        }
    }
}