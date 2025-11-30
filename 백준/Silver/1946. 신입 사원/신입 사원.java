import java.util.*;
import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());
        for(int i=0; i<len; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            
            for(int j=0; j<n; j++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                arr[x] = y;
            }
            
            int prev = arr[1];
            int count = 1;
            for(int j=2; j<=n; j++) {
                if(arr[j] < prev) {
                    count++;
                    prev = arr[j];
                }
            }
            
            sb.append(count + "\n");
        }
        System.out.println(sb);    
    }
}