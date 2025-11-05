import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution
{
    static String[][] arr;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int n = Integer.parseInt(br.readLine());
            arr = new String[100][100];
            for(int i=0; i<100; i++) {
                arr[i] = br.readLine().split("");
            }


            int max= 0;
            for(int i=0; i<100; i++) {
                for(int k=0; k<100; k++) {
                    max = Math.max(max, func(i,k));
                }
            }

            System.out.println("#"+n+" "+max);
        }
    }

    private static int func(int y, int x) {
        int yOddLength = 1;
        int xOddLength = 1;
        int yEvenLength = 0;
        int xEvenLength = 0;
        for(int c=1; y-c>=0 && y+c<100; c++) {
            if(!arr[y-c][x].equals(arr[y+c][x])) break;
            yOddLength += 2;
        }
        for(int c=0; y-c>=0 && y+c+1<100; c++) {
            if(!arr[y-c][x].equals(arr[y+c+1][x])) break;
            yEvenLength += 2;
        }

        for(int c=1; x-c>=0 && x+c<100; c++) {
            if(!arr[y][x-c].equals(arr[y][x+c])) break;
            xOddLength += 2;
        }
        for(int c=0; x-c>=0 && x+c+1<100; c++) {
            if(!arr[y][x-c].equals(arr[y][x+c+1])) break;
            xEvenLength += 2;
        }

        int result1= Math.max(xEvenLength, yEvenLength);
        int result2= Math.max(xOddLength, yOddLength);
        return Math.max(result1, result2);
    }
}