import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input1 = br.readLine();
        String input2 = br.readLine();
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : input1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c: input2.toCharArray()) {
            if(map.containsKey(c)) {
                if(map.get(c) == 1) map.remove(c);
                else map.put(c, map.get(c)-1);
            }
            else {
                count++;
            }
        }

        for(int num : map.values()) {
            count += num;
        }
        System.out.println(count);
    }
}
