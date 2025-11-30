import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] rawCrains = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());
        int[] rawBoxes = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> crains = new ArrayList<>();
        for(int i=0; i<n; i++) {
            crains.add(rawCrains[i]);
        }
        crains.sort((a,b) -> b - a);
        List<Integer> boxes = new ArrayList<>();
        for(int i=0; i<m; i++) {
            boxes.add(rawBoxes[i]);
        }
        boxes.sort((a,b) -> b - a);

        int result = 0;
        while(!boxes.isEmpty()) {
            int num = boxes.size();
            int nCrain = 0;
            int nBox = 0;

            while(nCrain < n && nBox < boxes.size()) {
                if (crains.get(nCrain) >= boxes.get(nBox)) {
                    nCrain++;
                    boxes.remove(nBox);
                } else {
                    nBox++;
                }
            }
            if(boxes.size() == num) {
                result = -1;
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}
