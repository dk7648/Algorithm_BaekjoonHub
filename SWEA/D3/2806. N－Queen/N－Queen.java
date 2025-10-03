import java.util.Scanner;
class Solution
{
    static int result;
    static int n;
    static int[] arr;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            arr = new int[n];
            result = 0;
            func(0);
            System.out.println("#"+test_case+" "+result);
        }
    }
    public static void func(int depth) {
        if(depth == n) {
            result++;
            return;
        }

        for(int i=0;i <n; i++) {
            arr[depth] = i;
            if(isValid(depth)) {
                func(depth+1);
            }
        }
    }
    public static boolean isValid(int depth) {
        for(int i=0; i<depth; i++) {
            if(arr[i] == arr[depth])
                return false;
            if(Math.abs(depth-i) == Math.abs(arr[depth]-arr[i]))
                return false;
        }
        return true;
    }
}