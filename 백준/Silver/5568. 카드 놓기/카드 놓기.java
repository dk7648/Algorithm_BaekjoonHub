import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    static int n;
    static int k;
    static String[] arr;
    static Set<String> set;
    static boolean[] isVisit;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        set = new HashSet<>();
        isVisit = new boolean[n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        dfs("", 0);
        System.out.println(set.size());

    }
    public static void dfs(String sum, int depth) {
        if(depth == k) {
            set.add(sum);
            return;
        }

        for(int i=0; i<n; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                dfs(sum+arr[i], depth+1);
                isVisit[i] = false;
            }
        }
    }
}
