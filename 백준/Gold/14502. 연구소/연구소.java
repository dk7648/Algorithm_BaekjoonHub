import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int max;
    static int N;
    static int M;
    static int[][] map;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        max = 0;
        map = new int[N][M];
        for(int i=0; i<N; i++) {
            input = br.readLine().split(" ");
            for(int k=0; k<M; k++) {
                map[i][k] = Integer.parseInt(input[k]);
            }
        }

        dfs(0);
        System.out.println(max);
    }
    public static void dfs(int depth) {
        if(depth == 3) {
            max = Math.max(max, simulate());
            return;
        }
        //벽 세우기
        for(int i=0; i<N; i++) {
            for(int k=0; k<M; k++) {
                if(map[i][k] == 0) {
                    map[i][k] = 1;
                    dfs(depth+1);
                    map[i][k] = 0;
                }
            }
        }
    }

    public static int simulate() {
        boolean[][] isVisit = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++) {
            for (int k = 0; k < M; k++) {
                if(map[i][k] == 2) {
                    q.add(new int[]{i,k});
                    isVisit[i][k] = true;
                }
            }
        }

        //바이러스 퍼뜨리기
        while(!q.isEmpty()) {
            int[] target = q.poll();
            int y = target[0];
            int x = target[1];
            for(int i=0; i<4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[ny][nx] == 1) continue; //벽일 경우
                if(isVisit[ny][nx]) continue;
                q.add(new int[]{ny, nx});
                isVisit[ny][nx] = true;
            }
        }

        //빈칸 개수 세기
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int k=0; k<M; k++) {
                if(!isVisit[i][k] && map[i][k] == 0) count++;
            }
        }
        return count;
    }
}
