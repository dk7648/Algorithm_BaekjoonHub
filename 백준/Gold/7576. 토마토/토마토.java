import java.util.*;
import java.io.*;

class Main {
    private static class Pos {
        public int x;
        public int y;
        public Pos(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Pos> q = new LinkedList<>();
        int[] dy = {-1,0,1,0};
        int[] dx = {0,1,0,-1};
        
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int w = data[0];
        int h = data[1];
        
        int[][] map = new int[h][w];
        int[][] dist = new int[h][w];
        for(int i=0; i<h; i++) {
            data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int k=0; k<w; k++) {
                map[i][k] = data[k];
                if(data[k] == 1) {
                    q.add(new Pos(i,k));
                }
                if(data[k] == 0) {
                    dist[i][k] = -1;
                }
            }
        }
    
        while(!q.isEmpty()) {
            Pos target = q.poll();
            for(int i=0; i<4; i++) {
                int nx = target.x+dx[i];
                int ny = target.y+dy[i];
                if(nx <0 || nx >= w || ny < 0 || ny >= h) continue;
                if(dist[ny][nx] >= 0) continue;
                q.add(new Pos(ny, nx));
                dist[ny][nx] = dist[target.y][target.x] + 1;
            }
        }

        int max = 0;
        for(int i=0; i<h; i++) {
            for(int k=0; k<w; k++) {
                if(dist[i][k] == -1) {
                    System.out.println(-1);
                    return;
                }
                max = Math.max(max, dist[i][k]);
            }
        }
        System.out.println(max);
        return;
    }
}