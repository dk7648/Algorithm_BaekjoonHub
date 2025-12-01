import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split("-");

        int result = 0;
        for(int i=0; i<input.length; i++) {
            String[] temp = input[i].split("\\+");
            int num = 0;
            for(int k=0; k<temp.length; k++) {
                num += Integer.parseInt(temp[k]);
            }
            result += i == 0 ? num : -num;
        }
        System.out.println(result);
    }
}
