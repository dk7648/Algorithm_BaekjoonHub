import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> sortedGenres = new LinkedList<>(map.entrySet());
        sortedGenres.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); //play순으로 장르 정렬
        
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<n; i++) {
            map2.put(i, plays[i]);
        }
        List<Map.Entry<Integer, Integer>> sortedIndexes = new LinkedList<>(map2.entrySet());
        sortedIndexes.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue())); //play순으로 고유번호 정렬
        
        List<Integer> result = new LinkedList<>();
        for (Map.Entry<String, Integer> e : sortedGenres) {
            List<Integer> t = new LinkedList<>();
            String key = String.valueOf(e.getKey());
            for(int i=0; i<n; i++) {
                int index = sortedIndexes.get(i).getKey();
                if(genres[index].equals(key) && t.size() < 2) {
                    t.add(index);
                }
            }
            for(int index : t) {
                result.add(index);
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}