import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Solution
{
    static int prev;
    static int max;
    static String[] numbers;
    static int repeat;
    static HashSet<String>[] isVisit;
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            max = 0;
            prev = 0;
            String[] input = br.readLine().split(" ");
            numbers = input[0].split("");
            repeat = Integer.parseInt(input[1]);
            isVisit = new HashSet[repeat + 1];
            for (int d = 0; d <= repeat; d++) isVisit[d] = new HashSet<>();

            dfs(0);

            System.out.println("#"+test_case+" "+max);
        }

    }
    public static void dfs(int depth) {

        if(depth >= repeat) {
            max = Math.max(max, Integer.parseInt(String.join("", numbers)));
            return;
        }
        String state = String.join("", numbers);
        if(isVisit[depth].contains(state)) {
            return;
        }
        isVisit[depth].add(state);
        for(int i=0; i< numbers.length; i++) {
            for(int k=0; k< numbers.length; k++) {
                if (i == k) continue;

                swap(i, k);
                dfs(depth + 1);
                swap(i, k);
            }
        }
    }
    public static void swap(int prev, int next) {
        String temp = numbers[prev];
        numbers[prev] = numbers[next];
        numbers[next] = temp;
    }
}