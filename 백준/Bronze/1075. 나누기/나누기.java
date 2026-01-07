import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());
        int min = n / 100 * 100;

        for(int i=0; i<100; i++) {
            if((min+i) % f == 0) {
                System.out.println(String.format("%02d", i) );
                break;
            }
        }
    }
}