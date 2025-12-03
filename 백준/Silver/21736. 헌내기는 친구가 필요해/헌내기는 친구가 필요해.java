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
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        String[][] map = new String[N][M];
        boolean[][] isVisit = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++) {
            map[i] = br.readLine().split("");
            for(int k=0; k<M; k++) {
                if("I".equals(map[i][k])) {
                    queue.add(new int[]{i,k});
                    isVisit[i][k] = true;
                }
            }
        }
        int count = 0;
        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            for(int i=0; i<4; i++) {
                int ny = pos[0] + dy[i];
                int nx = pos[1] + dx[i];
                if(ny < 0 || ny >=N || nx < 0 || nx >=M) continue;
                if(isVisit[ny][nx]) continue;
                if("X".equals(map[ny][nx])) continue;
                if("P".equals(map[ny][nx])) count++;
                isVisit[ny][nx] = true;
                queue.add(new int[]{ny,nx});
            }
        }
        if(count == 0) System.out.println("TT");
        else System.out.println(count);
    }
}
