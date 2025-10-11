import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static String[][] arr;
    static int n;
    public static void main(String args[]) throws Exception
    {
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int result = 0;
            n = Integer.parseInt(br.readLine());
            arr = new String[8][8];
            for(int i=0; i<8; i++) {
                arr[i] = br.readLine().split("");
            }
            
            for(int i=0; i<8; i++) {
                for(int k=0; k<8; k++) {
                    result += isValid(i,k);
                }
            }

            System.out.println("#"+test_case+" "+result);
        }
    }

    private static int isValid(int h, int w) {
        int vertical = 1;
        int horizontal = 1;
        for(int i=0; i<n/2; i++) {
            if(w+i > 7 || w+n-i-1 > 7 || !arr[h][w+i].equals(arr[h][w+n-i-1])) {
                horizontal = 0;
            }
            if(h+i > 7 || h+n-i-1 > 7 || !arr[h+i][w].equals(arr[h+n-i-1][w])) {
                vertical = 0;
            }
        }
        return vertical+horizontal;
    }
}