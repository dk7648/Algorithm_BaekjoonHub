import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Point;
import java.util.Stack;


class Main
{
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int M;
    static int N;
    static int K;
    static int[][] arr;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case=0; test_case<T; test_case++) {
            int count = 0;

            String[] input = br.readLine().split(" ");
            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);
            arr = new int[N][M];
            for(int i=0; i<K; i++) {
                input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                arr[y][x] = 1;
            }

            for(int i=0; i<N; i++) {
                for(int k=0; k<M; k++) {
                    if(arr[i][k] == 1) {
                        bfs(k,i);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }


    }

    private static void bfs(int x, int y) {
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(x,y));
        while(!stack.isEmpty()) {
            Point target = stack.pop();
            for(int j=0; j<4; j++) {
                int nx = target.x + dx[j];
                int ny = target.y + dy[j];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(arr[ny][nx] == 0) continue;
                arr[ny][nx] = 0;
                stack.push(new Point(nx, ny));
            }
        }
    }
}
