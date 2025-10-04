
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;
import java.awt.Point;

class Solution
{
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n][n];
            int[][] dist = new int[n][n];
            for(int i=0; i<n; i++) {
                map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            }
            for(int i=0; i<n; i++) {
                for(int k=0; k<n; k++) {
                    dist[i][k] = 999;
                }
            }
            dist[0][0] = 0;
            Stack<Point> stack = new Stack<>();
            stack.push(new Point(0, 0));

            while(!stack.isEmpty()) {
                Point target = stack.pop();
                for(int i=0; i<4; i++) {
                    int nx = target.x+dx[i];
                    int ny = target.y+dy[i];
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                    if(dist[ny][nx] <= dist[target.y][target.x] + map[ny][nx]) continue;
                    dist[ny][nx] = dist[target.y][target.x] + map[ny][nx];
                    stack.push(new Point(nx, ny));
                }
            }
            System.out.println("#"+test_case+" "+dist[n-1][n-1]);
        }
    }
}