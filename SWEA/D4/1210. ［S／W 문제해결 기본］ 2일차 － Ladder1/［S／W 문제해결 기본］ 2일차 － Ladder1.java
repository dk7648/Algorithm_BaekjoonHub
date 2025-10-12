import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Solution
{
    static int[][] map;
    static int[] dy = {0,0,1};
    static int[] dx = {-1,1,0};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int result = 0;
            int n = Integer.parseInt(br.readLine());
            boolean[][] isVisit = new boolean[100][100];
            Stack<Point> stack = new Stack<>();
            map = new int[100][100];
            for(int i=0; i<100; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            for(int i=0; i<100; i++) {
                if(map[0][i] == 1) stack.push(new Point(i,0));
            }

            while(!stack.isEmpty()) {
                Point target = stack.pop();
                if(target.y == 0) {
                    result = target.x;
                    isVisit = new boolean[100][100];
                }
                for(int i=0; i<3; i++) {
                    int ny = target.y + dy[i];
                    int nx = target.x + dx[i];
                    if(ny < 0 || ny >= 100 || nx < 0 || nx >= 100) continue;
                    if(map[ny][nx] == 0) continue;
                    if(isVisit[ny][nx]) continue;
                    if(map[ny][nx] == 2) {
                        stack.clear();
                        break;
                    }
                    isVisit[ny][nx] = true;
                    stack.push(new Point(nx, ny));
                    break;
                }
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}