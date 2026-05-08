import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<number.length(); i++) {
            int current = number.charAt(i) - '0';
            while(k>0 && !stack.isEmpty() && stack.peek() < current) {
                k--;
                stack.pop();
            }
            stack.push(current);
        }
        while(k>0) {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}