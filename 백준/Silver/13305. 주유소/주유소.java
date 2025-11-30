import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] distance = new int[len];
        int[] price = new int[len];
        
        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        for(int i=1; i<len; i++) {
            distance[i] = Integer.parseInt(input1[i-1]);
        }
        for(int i=0; i<len; i++) {
            price[i] = Integer.parseInt(input2[i]);
        }
        
        long result = 0;
        int i = 0;
        while (i < len-1) {
            int minIdx = i;
            long d = 0;
            for(int j=i+1; j<len; j++) {
                d += distance[j];
                if(price[minIdx] > price[j]) {
                    minIdx = j;
                    break;
                }
            }
            if(minIdx == i) //지금보다 싼 가격이 이후에 없을 경우.
                minIdx = len-1;
                
            result += d * price[i];
            i = minIdx;
        }
        System.out.println(result);
    }
}