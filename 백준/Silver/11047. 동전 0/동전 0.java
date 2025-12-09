import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[N-1-i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int index = 0;
        while(K > 0 || index < N) {
            count += K/arr[index];
            K = K % arr[index];
            index++;
        }
        System.out.println(count);
    }
}
