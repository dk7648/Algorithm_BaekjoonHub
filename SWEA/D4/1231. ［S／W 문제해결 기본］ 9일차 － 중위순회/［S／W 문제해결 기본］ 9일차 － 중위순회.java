import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
    static String[] arr;
    static int result;
    static StringBuilder sb;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            arr = new String[n*2+2];
            for(int i=0; i<n; i++) {
                String[] input = br.readLine().split(" ");
                int index = Integer.parseInt(input[0]);
                String value = input[1];
                arr[index] = value;
            }
            inorder(1);
            System.out.println("#"+test_case+" "+sb);
        }
    }
    public static void inorder(int index) {
        if(arr[index] == null) return;

        inorder(index*2);
        sb.append(arr[index]);
        inorder(index*2+1);
    }
}