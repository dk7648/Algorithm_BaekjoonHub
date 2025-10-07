import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;
import java.awt.Point;
class Solution
{
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] isVisit;
    static int[][] map;
    static Queue<Point> q;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            q = new LinkedList<>();
            isVisit = new boolean[100][100];
            map = new int[100][100];
            for(int i=0; i<100; i++) {
                String[] input = br.readLine().split("");
                for(int k=0; k<100; k++) {
                    map[i][k] = Integer.parseInt(input[k]);
                    if(map[i][k] == 2) q.offer(new Point(k,i));
                }
            }
            int result = dfs();
            System.out.println("#"+test_case+" "+result);
        }
    }
    public static int dfs() {
        while(!q.isEmpty()) {
            Point target = q.poll();
            for(int i=0; i<4; i++) {
                int nx = target.x + dx[i];
                int ny = target.y + dy[i];
                if(nx < 0 || nx >= 100 || ny < 0 || ny >= 100) continue;
                if(map[ny][nx] == 1) continue;
                if(isVisit[ny][nx]) continue;
                if(map[ny][nx] == 3) return 1;
                isVisit[ny][nx] = true;
                q.offer(new Point(nx, ny));
            }
        }
        return 0;
    }
}