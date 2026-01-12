import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Integer> stack = new Stack<>();
        int next = 1;
        for(int i=0; i<n; i++) {
            int cur = arr[i];
            if(cur == next) {
                next++;
                while(stack.size() > 0 && stack.peek() == next) {
                    stack.pop();
                    next++;
                }
            }
            else {
                stack.push(cur);
            }
        }
        while(stack.size() > 0 && stack.peek() == next) {
            stack.pop();
            next++;
        }

        if(stack.size() > 0) System.out.println("Sad");
        else System.out.println("Nice");
    }
}