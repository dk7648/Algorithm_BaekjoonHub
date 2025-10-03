import java.util.Scanner;
import java.util.Stack;

class Solution
{
    static String[] infix;
    static String[] postfix;
    static int length;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        for(int test_case = 1; test_case <= 10; test_case++)
        {
            length = sc.nextInt();
            sc.nextLine();
            infix = sc.nextLine().split("");
            postfix = new String[length];

            convertInfixToPostfix();
            int result = calculatePostfix();

            System.out.println("#"+test_case+" "+result);
        }
    }
    public static void convertInfixToPostfix() {
        Stack<String> stack = new Stack<>();
        int index = 0;

        for(int i=0; i<length; i++) {
            if(infix[i].matches("[0-9]")) {
                postfix[index++] = infix[i];
            }
            else {
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(infix[i])) {
                    postfix[index++] = stack.pop();
                }
                stack.add(infix[i]);
            }
        }
        while(!stack.isEmpty()) {
            postfix[index++] = stack.pop();
        }
    }
    public static int getPriority(String op) {
        if(op.equals("+") || op.equals("-")) return 1;
        if(op.equals("*") || op.equals("/")) return 2;
        return -1;
    }

    public static int calculatePostfix() {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<length; i++) {
            if(postfix[i].matches("[0-9]")) {
                stack.add(Integer.parseInt(postfix[i]));
            }
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch(postfix[i]) {
                    case "+":
                        stack.add(n1+n2);
                        break;
                    case "-":
                        stack.add(n1-n2);
                        break;
                    case "*":
                        stack.add(n1*n2);
                        break;
                    case "/":
                        stack.add(n1/n2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}