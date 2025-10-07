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
    static int[][] arr;
    static Queue<Point> q;
    static int n;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            n = Integer.parseInt(br.readLine().split(" ")[1]);
            arr = new int[100][100];
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int i=0; i<input.length; i+=2) {
                int src = input[i];
                int dest = input[i+1];
                arr[src][dest] = 1;
            }
            int result = bfs();
            System.out.println("#"+test_case+" "+result);

        }
    }
    public static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        while(!q.isEmpty()) {
            int target = q.poll();
            for(int dest=0; dest<100; dest++) {
                if(arr[target][dest] == 1) {
                    if(dest == 99) return 1;
                    q.offer(dest);
                }
            }
        }
        return 0;
    }
}