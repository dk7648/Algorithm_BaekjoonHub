import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] devices = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> multitab = new LinkedList<>();

        int count = 0;
        for(int i=0; i<k; i++) {
            int curDevice = devices[i];
            if(multitab.contains(curDevice)) continue;
            if(multitab.size() < n) {
                multitab.add(curDevice);
                continue;
            }

            int farestIndex = -1;
            int removeDevice = -1;
            for(int device : multitab) {
                int nextIndex = 999;
                for(int j=i; j<k; j++) {
                    if(devices[j] == device) {
                        nextIndex = j;
                        break;
                    }
                }

                if(nextIndex > farestIndex) {
                    farestIndex = nextIndex;
                    removeDevice = device;
                }
            }
            multitab.remove((Object)removeDevice);
            multitab.add(curDevice);
            count++;
        }
        System.out.println(count);
    }
}
