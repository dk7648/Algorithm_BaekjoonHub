import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long count = 0;
            int n = sc.nextInt();
            Queue<Point> q = new LinkedList<>();
            for(int i=0; i<n; i++) {
                int t1 = sc.nextInt();
                int t2 = sc.nextInt();
                q.add(new Point(t1, t2));
            }

            while(!q.isEmpty()) {
                Point target = q.poll();
                int len = q.size();
                for(int k=0; k<len; k++) {
                    Point t = q.poll();
                    long dx = (long)target.x - t.x;
                    long dy = (long)target.y - t.y;
                    if(dx * dy < 0) {
                        count++;
                    }
                    q.add(t);
                }
            }
            System.out.println("#"+test_case+" "+count);
        }
    }
}