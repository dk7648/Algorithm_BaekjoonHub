import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = 0;
            int x1 = input[0];
            int y1 = input[1];
            int r1 = input[2];
            int x2 = input[3];
            int y2 = input[4];
            int r2 = input[5];

            if(x1 == x2 && y1 == y2) {
                if(r1 == r2) count = -1;
                else count = 0;
            }
            else {
                int d = getDistance(x1,y1,x2,y2);
                int r = (int)Math.pow(r1+r2,2);
                if(r < d) count = 0;
                else if(Math.pow(r2 - r1,2) > d) count = 0;
                else if(r==d) count = 1;
                else if((int)Math.pow(r1-r2,2) == d) count = 1;
                else count = 2;
            }
            System.out.println(count);
        }
    }
    public static int getDistance(int x1, int y1, int x2, int y2) {
        int distX = Math.abs(x1-x2);
        int distY = Math.abs(y1-y2);
        return (int)Math.pow(distX,2) + (int)Math.pow(distY, 2);
    }
}
