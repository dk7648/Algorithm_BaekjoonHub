import java.util.*;
import java.io.*;

class Main {
    private static class Pos {
        public int y;
        public int x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
        
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int height = data[0];
        int width = data[1];

        Queue<Pos> qj = new LinkedList<>();
        Queue<Pos> qf = new LinkedList<>();
        
        String[][] map = new String[height][width];
        int[][] distJ = new int[height][width];
        int[][] distF = new int[height][width];
        for(int i=0; i<height; i++) {
            String[] mapData = br.readLine().split("");
            for(int k=0; k<width; k++) {
                map[i][k] = mapData[k];
                if(map[i][k].equals(".")) {
                    distJ[i][k] = -1;
                    distF[i][k] = -1;
                }
                if(map[i][k].equals("J")) {
                    qj.add(new Pos(i, k));
                    distJ[i][k] = 0;
                    distF[i][k] = -1;
                }
                if(map[i][k].equals("F")) {
                    qf.add(new Pos(i, k));
                    distJ[i][k] = 999999;
                    distF[i][k] = 0;
                }
                if(map[i][k].equals("#")) {
                    distJ[i][k] = 999999;
                    distF[i][k] = 999999;
                }
            }
        }

        int[] dy = {-1, 0, 1, 0};
        int[] dx = {0, 1, 0, -1};
        while(!qf.isEmpty()) {
            Pos p = qf.poll();
            for(int i=0; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= height || nx < 0 || nx >= width) continue;
                if(distF[ny][nx] >= 0) continue;
                qf.add(new Pos(ny,nx));
                distF[ny][nx] = distF[p.y][p.x]+1;
            }
        }

        while(!qj.isEmpty()) {
            Pos p = qj.poll();
            for(int i=0; i<4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];
                if(ny < 0 || ny >= height || nx < 0 || nx >= width) continue;
                if(distJ[ny][nx] >= 0 || (distF[ny][nx] != -1 && distJ[p.y][p.x]+1 >= distF[ny][nx])) continue;
                qj.add(new Pos(ny,nx));
                distJ[ny][nx] = distJ[p.y][p.x]+1;
            }
        }

        int min = 999999;
        for(int i=0; i<height; i++) {
            for(int k=0; k<width; k++) {
                if(i==0 || k==0 || i==height-1 || k == width-1) {
                    if(distJ[i][k] >= 0) {
                        min = Math.min(min, distJ[i][k]);
                    }
                }
            }
        }
        if(min == 999999) System.out.println("IMPOSSIBLE");
        else System.out.println(min+1);
    }
}