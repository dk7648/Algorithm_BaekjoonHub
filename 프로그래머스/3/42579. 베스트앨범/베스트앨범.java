import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> totalRank = new HashMap<>();
        Map<String, List<int[]>> detailRank = new HashMap<>();
        for(int i=0; i<n; i++) {
            totalRank.put(genres[i], totalRank.getOrDefault(genres[i], 0) + plays[i]);
            
            List<int[]> list = detailRank.getOrDefault(genres[i], new ArrayList<>());
            list.add(new int[]{i, plays[i]});      
            detailRank.put(genres[i], list);
        }
        List<String> genreRank = new ArrayList<>();
        genreRank.addAll(totalRank.keySet());
        genreRank.sort((a,b)->totalRank.get(b) - totalRank.get(a));
        
        List<Integer> result = new ArrayList<>();
        for(String genre : genreRank) {
            List<int[]> list = detailRank.get(genre);
            list.sort((a,b)-> {
                if(a[1] == b[1]) return a[0] - b[0];
                return b[1] - a[1];
            });
            
            result.add(list.get(0)[0]);
            if(list.size() > 1) {
                result.add(list.get(1)[0]);
            }
        }        
        int[] answer = new int[result.size()];
        
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}