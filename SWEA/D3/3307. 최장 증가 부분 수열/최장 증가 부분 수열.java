import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            long max = 0;
            long[] arr = new long[n];
            long[] lengths = new long[n];

            for(int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            
            //나보다 크다?
            //해당 값에 1 제공
            //해당 값 이상의 값일 때의 길이값+1
            
            for(int i=n-1; i>=0; i--) {
                lengths[i] = 1;
                for(int k=n-1; k>i; k--) {
                    if(arr[i] <= arr[k]) {
                        lengths[i] = Math.max(lengths[i], lengths[k]+1);
                    }
                }
                max = Math.max(max, lengths[i]);
            }
            System.out.println("#"+test_case+" "+max);
        }
    }
}