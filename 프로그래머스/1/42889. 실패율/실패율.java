import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] nStagePlayer = new int[N+2];
        
        
        for(int stage : stages) {
            nStagePlayer[stage]++;
        }

        Map<Integer, Double> nStageFailure = new HashMap<>();
        int nArrivedPlayer = nStagePlayer[N+1];
        for(int i=N; i>0; i--) {
            nArrivedPlayer += nStagePlayer[i];
            double failure = nArrivedPlayer > 0 ? (double)nStagePlayer[i] / nArrivedPlayer : 0;
            nStageFailure.put(i, failure);
        }

        List<Integer> list = new ArrayList<>(nStageFailure.keySet());
        list.sort((o1, o2) -> nStageFailure.get(o2).compareTo(nStageFailure.get(o1)));
            
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}