import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Point;
import java.nio.Buffer;
import java.util.*;


class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        Map<String, String> map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            String name = br.readLine();
            String number = String.valueOf(i);
            map.put(name, number);
            map.put(number, name);
        }

        for(int i=1; i<=M; i++) {
            String key = br.readLine();
            sb.append(map.get(key)).append("\n");
        }
        System.out.println(sb);
    }
}