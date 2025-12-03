import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[0]);
        String[][] map = new String[N][M];
        int[][] dist = new int[N][M];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split(" ");
            for(int k=0; k<M; k++) {
                if(map[i][k].equals("1")) {
                    dist[i][k] = 0;
                    q.add(new int[]{i,k});
                } else if(map[i][k].equals("0")) {
                    dist[i][k] = -1;
                }
            }
        }

        while(!q.isEmpty()) {
            int[] target=  q.poll();
            for(int i=0; i<4; i++) {
                int ny = target[0]+dy[i];
                int nx = target[1]+dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(dist[ny][nx] >= 0) continue;
                q.add(new int[]{ny,nx});
                dist[ny][nx] = dist[target[0]][target[1]] + 1;

            }
        }
        int max = 0;
        for(int i=0; i<N; i++) {
            for(int k=0;k<M; k++) {
                if(dist[i][k] == -1) {
                    System.out.println(-1); return;
                }
                max = Math.max(max, dist[i][k]);
            }
        }
        System.out.println(max);
    }
}
