import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int max;
    static boolean[][] isVisit;
    static int[] dy = {-1,0,1,0};
    static int[] dx = {0,1,0,-1};
    static int height;
    static int width;
    static int[][] arr;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        height = Integer.parseInt(input[0]);
        width = Integer.parseInt(input[1]);
        arr = new int[height][width];
        for(int i=0; i<height; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        isVisit = new boolean[height][width];

        max = 0;
        for(int h=0; h<height; h++) {
            for(int w=0; w<width; w++) {
                isVisit[h][w] = true;
                func(h,w,arr[h][w], 1);
                isVisit[h][w] = false;
                
                checkTBlock(h,w);
            }
        }
        System.out.println(max);
    }

    private static void checkTBlock(int h, int w) {
        //ㅗ
        if(h-1 >= 0 && w-1 >= 0 && w+1 < width) {
            max = Math.max(max, arr[h-1][w] + arr[h][w] + arr[h][w-1] + arr[h][w+1]);
        }
        //ㅏ
        if(h-1 >= 0 && h+1 < height && w+1 < width) {
            max = Math.max(max, arr[h-1][w] + arr[h][w] + arr[h+1][w] + arr[h][w+1]);
        }
        //ㅜ
        if(h+1 < height && w-1 >= 0 && w+1 < width) {
            max = Math.max(max, arr[h+1][w] + arr[h][w] + arr[h][w-1] + arr[h][w+1]);
        }
        //ㅓ
        if(h-1 >= 0 && h+1 < height && w-1 >= 0) {
            max = Math.max(max, arr[h-1][w] + arr[h][w] + arr[h+1][w] + arr[h][w-1]);
        }
    }

    private static void func(int y, int x, int sum, int depth) {
        if(depth == 4) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=0; i<4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || nx >= width || ny < 0 || ny >= height) continue;
            if(isVisit[ny][nx]) continue;
            isVisit[ny][nx] = true;
            func(ny,nx,sum + arr[ny][nx],depth+1);
            isVisit[ny][nx] = false;

        }
    }
}
