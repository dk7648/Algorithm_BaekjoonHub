import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(ch == ')') {
                if(stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            else stack.push(ch);
        }
        return stack.isEmpty();
    }
}