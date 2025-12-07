import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()) {
            if(!stack.isEmpty() && ch == stack.peek()) {
                int n = stack.pop();
            } else {
                stack.add(ch);
            }
        }
        
        return stack.size() == 0 ? 1 : 0;
    }
}