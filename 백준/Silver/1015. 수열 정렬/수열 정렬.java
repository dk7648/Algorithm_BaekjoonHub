import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] rank = new int[N];
        for(int i=0; i<N; i++) {
            rank[i] = arr[i];
        }
        Arrays.sort(rank);
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(arr[i] == rank[j]) {
                    sb.append(j).append(" ");
                    rank[j] = -1;
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}