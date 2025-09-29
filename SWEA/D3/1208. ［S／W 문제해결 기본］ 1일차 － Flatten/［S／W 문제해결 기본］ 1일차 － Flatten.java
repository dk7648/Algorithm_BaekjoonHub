import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dumpCount = Integer.parseInt(br.readLine());
            String[] init = br.readLine().split(" ");
            int[] arr = new int[init.length];

            for(int i=0; i< init.length; i++) {
                int height = Integer.parseInt(init[i]);
               arr[i] = height;
            }

            Arrays.sort(arr);

            int count = 0;
            while(arr[0] != arr[init.length-1] && count < dumpCount) {
                int rightMin = 0;
                int leftMax = init.length - 1;
                while (rightMin < init.length - 1 && arr[rightMin] == arr[rightMin + 1]) rightMin++;
                while (leftMax > 1 && arr[leftMax - 1] == arr[leftMax]) leftMax--;

                arr[rightMin]++;
                arr[leftMax]--;
                count++;
            }
            
            System.out.println("#"+test_case+" "+(arr[init.length-1] - arr[0]));
        }
    }
}