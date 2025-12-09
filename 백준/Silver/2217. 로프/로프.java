import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int max = 0;
        for(int i=0; i<N; i++) {
            max = Math.max(max, arr[i]*(N-i));
        }
        System.out.println(max);
    }
}
