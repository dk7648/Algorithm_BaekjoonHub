import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int twinhorn = 0;
            int unicorn = 0;
            for(int i=0; i<=m; i++) {
                if(n == i*2+(m-i)) {
                    twinhorn = i;
                    unicorn = m-i;
                    break;
                }
            }
            System.out.println("#"+test_case+" "+unicorn+" "+twinhorn);
        }
    }
}