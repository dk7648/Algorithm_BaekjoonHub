import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution
{
    static String[] arr;
    static int result;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            arr = new String[n*2+2];
            result = 1;
            for(int i=0; i<n; i++) {
                String[] input = br.readLine().split(" ");
                int index = Integer.parseInt(input[0]);
                String value = input[1];
                arr[index] = value;
            }
            searchLeafNode(1);
            System.out.println("#"+test_case+" "+result);
        }
    }
    public static void searchLeafNode(int index) {
        if(arr[index] == null) return;
        if(arr[index*2]==null && arr[index*2+1] == null) {
            if(!arr[index].matches("[0-9]")) result = 0;
        }

        searchLeafNode(index*2);
        searchLeafNode(index*2+1);
    }
}