import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0; i<n; i++) {
            map2.put(i, plays[i]);
        }
        
        List<Integer> result = new LinkedList<>();
        List<String> sortedGenres = sortedByValue(map);
        List<Integer> sortedIndexes = sortedByValue(map2);
        
        for (String key : sortedGenres) {
            int count = 0;
            for(int i=0; i<n; i++) {
                int index = sortedIndexes.get(i);
                if(genres[index].equals(key)) {
                    result.add(index);
                    count++;
                }
                if(count >= 2) break;
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
    
    public ArrayList sortedByValue(final Map map) {
        ArrayList<Object> list = new ArrayList<>();
        list.addAll(map.keySet());
        
        list.sort((o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });
        return list;
    }
}