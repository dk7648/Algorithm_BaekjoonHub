import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        for(int i=0; i<citations.length/2; i++) {
            int t = citations[i];
            citations[i] = citations[citations.length-1-i];
            citations[citations.length-1-i] = t;
        }
        
        for(int h=citations.length; h>=0; h--) {
            int i=0;
            while(i < citations.length && citations[i] >= h) i++;
            if(i >= h) return h;
        }
        return -1;
    }
}