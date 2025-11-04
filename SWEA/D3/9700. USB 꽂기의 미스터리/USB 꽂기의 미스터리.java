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
            StringBuilder sb = new StringBuilder();
            sb.append("#"+test_case+" ");
            String[] input = br.readLine().split(" ");
            Double p = Double.parseDouble(input[0]);
            Double q = Double.parseDouble(input[1]);

            Double s1 = (1-p)*q;
            Double s2 = p*(1-q)*q;

            if(s1 < s2) sb.append("YES");
            else sb.append("NO");
            System.out.println(sb);
        }
    }
}