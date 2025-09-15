import java.util.Arrays;
import java.util.Scanner;



class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = sc.nextInt();
            int[] heights = new int[n];
            int count = 0;
            for(int i=0; i<n; i++) {
                heights[i] = sc.nextInt();
            }

            for(int i=2; i<n-2; i++) {
                int[] surroundings = new int[] {heights[i-2], heights[i-1], heights[i+1], heights[i+2]};
                int max = Arrays.stream(surroundings).max().getAsInt();
                count += Math.max(heights[i] - max, 0);
            }
            System.out.println("#"+test_case+" "+count);
        }
    }
}