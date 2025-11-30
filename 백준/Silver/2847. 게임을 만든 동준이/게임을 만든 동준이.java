import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        for(int i=n-1; i>0; i--) {
            if(arr[i] <= arr[i-1]) {
               int count = arr[i-1]-arr[i]+1;
               arr[i-1] -= count;
               total += count;
            }
        }
        System.out.println(total);
    }
}
