import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split("\\+");
            int result = 0;
            for(int i=0; i<input.length; i++) {
                result += Integer.parseInt(input[i]);
            }
            System.out.println("#"+test_case+" "+result);
        }
    }
}