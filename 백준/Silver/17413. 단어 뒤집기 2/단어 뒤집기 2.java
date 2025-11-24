import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split("");
        Stack<String> stack = new Stack<>();
        boolean isSave = false;
        for(int i=0; i<input.length; i++) {
            String ch = input[i];
            if(ch.equals("<")) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
                isSave = true;
            }
            else if(ch.equals(">")) {
                sb.append(ch);
                isSave = false;
            }
            else if(ch.equals(" ")) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(ch);
            }
            else if(isSave) {
                sb.append(ch);
            }
            else {
                stack.push(ch);
            }


        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
