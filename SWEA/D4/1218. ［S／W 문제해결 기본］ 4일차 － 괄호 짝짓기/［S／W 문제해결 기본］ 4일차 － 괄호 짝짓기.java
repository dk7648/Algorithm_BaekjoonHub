import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;


class Solution
{
    static String[] open = {"(", "[", "{", "<"};
    static String[] close = {")", "]", "}", ">"};
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            stack.push("#");
            for(int i=0; i<n; i++) {
                String prev = stack.peek();
                String cur = input[i];
                stack.push(cur);

                for(int k=0; k<4; k++) {
                    if(open[k].equals(prev) && close[k].equals(cur)) {
                        stack.pop();
                        stack.pop();
                    }
                }
            }
            int result = stack.peek().equals("#") ? 1 : 0;
            System.out.println("#"+test_case+" "+result);
        }
    }
}