import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
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
            Stack<String> sstack = new Stack<>();
            String[] input = br.readLine().split("");
            List<String> list = new LinkedList<>();
            for(int i=0; i<input.length; i++) {
                String cur = input[i];
                if(cur.equals("(")) sstack.push(cur);
                else if(cur.equals("+") || cur.equals("*")) {
                    while(priority(cur) <= priority(sstack.peek())) list.add(sstack.pop());
                    sstack.push(cur);
                }
                else if(cur.equals(")")) {
                    while(!sstack.peek().equals("(")) list.add(sstack.pop());
                    sstack.pop();
                }
                else {
                    list.add(cur);
                }
            }

            Stack<Integer> istack = new Stack<>();
            for(int i=0; i<list.size(); i++) {
                String cur = list.get(i);
                if(cur.matches("[0-9]")) {
                    int number = Integer.parseInt(cur);
                    istack.push(number);
                }
                else {
                    int prev = istack.pop();
                    int next = istack.pop();
                    if(cur.equals("*")) istack.push(prev*next);
                    if(cur.equals("+")) istack.push(prev+next);
                }
            }
            int result = istack.pop();
            System.out.println("#"+test_case+" "+result);
        }
    }
    public static int priority(String op) {
        if(op.equals("(")) return 0;
        if(op.equals("+")) return 1;
        if(op.equals("*")) return 2;
        return -1;
    }
}