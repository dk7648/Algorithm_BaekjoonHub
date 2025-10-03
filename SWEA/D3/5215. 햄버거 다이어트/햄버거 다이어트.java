import java.util.Scanner;
class Solution
{
    static int n;
    static int maxCal;
    static int curCal;
    static int curScore;
    static int result;
    static int[] flavorScores;
    static int[] calories;
    static boolean[] isVisit;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            n = sc.nextInt();
            maxCal = sc.nextInt();
            curCal = 0;
            curScore = 0;
            result = 0;
            flavorScores = new int[n];
            calories = new int[n];
            isVisit = new boolean[n];

           for(int i=0; i<n; i++) {
                flavorScores[i] = sc.nextInt();
                calories[i] = sc.nextInt();
                func(0);
           }
           System.out.println("#"+test_case+" "+result);
        }
    }
    public static void func(int start) {
        if(curCal > maxCal) {
            return;
        }
        result = Math.max(result, curScore);
        for(int i=start; i<n; i++) {
            if(!isVisit[i]) {
                isVisit[i] = true;
                curCal += calories[i];
                curScore += flavorScores[i];
                func(i+1);
                curCal -= calories[i];
                curScore -= flavorScores[i];
                isVisit[i] = false;
            }
        }
    }
}