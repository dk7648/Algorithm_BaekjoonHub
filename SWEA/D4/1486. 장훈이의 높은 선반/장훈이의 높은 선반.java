import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileInputStream;


class Solution
{
    static int n;
    static int b;
    static int[] heights;
    static int min;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
          String[] input = br.readLine().split(" ");
          n = Integer.parseInt(input[0]);
          b = Integer.parseInt(input[1]);
          heights = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
          min = b;

          func(0,0);
          System.out.println("#"+test_case+" "+min);
        }
    }
    public static void func(int sum, int start) {
        int gap = sum-b;
        if(gap>=0 && gap<min) {
            min = gap;
            return;
        }
        if(gap > min) {
            return;
        }

        for(int i=start; i<n; i++) {
            func(sum+heights[i], i+1);
        }
    }
}