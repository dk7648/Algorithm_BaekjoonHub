import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0 ; test_case<T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] prices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            long max = 0;
            long money = 0;
            long stocks = 0;
            for(int i=0; i<n; i++) {
                if(max < prices[n-1-i]) {
                    money += max * stocks;
                    stocks = 0;
                    max = prices[n-1-i];
                } else {
                    money -= prices[n-1-i];
                    stocks++;
                }
            }
            money += max*stocks;
            System.out.println(money);
        }
    }
}
