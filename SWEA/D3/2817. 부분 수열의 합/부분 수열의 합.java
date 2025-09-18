import java.util.Scanner;
class Solution
{
    static int N;
    static int K;
    static int count;
    static int[] arr;
    static boolean[] isVisit;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = sc.nextInt();
            K = sc.nextInt();
            count = 0;
            arr = new int[N];
            isVisit = new boolean[N];
            for(int i=0; i<N; i++) {
                arr[i] = sc.nextInt();
            }

            func(0, 0);
            System.out.println("#"+test_case+" "+count);
        }

    }
    public static void func(int start, int sum) {
        if(sum >= K) {
            count += sum == K ? 1 : 0;
            return;
        }
        for(int i=start;i <N; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                func(i+1, sum + arr[i]);
                isVisit[i] = false;
            }
        }
    }
}