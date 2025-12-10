import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        //HEAD + NUMBER + TAIL
        //문자열 + 숫자 + 아무거나(or X)
        
        //HEAD정렬(대소문자X)
        //NUMBER정렬
        //둘다 같을 경우 기본 순서 유지
        
        //3등분 분할
        //HEAD순 정렬 그룹으로 나누기
        //같을 경우 숫자순정렬
        List<Object[]> list = new ArrayList<>();
        for(String file : files) {
            int numberBegin = 0;
            while(!Character.isDigit(file.charAt(numberBegin))) {
                numberBegin++;
            }
            String head = file.substring(0, numberBegin);
            
            int tailBegin = numberBegin;
            while(tailBegin < file.length() && Character.isDigit(file.charAt(tailBegin))) {
                tailBegin++;
            }
            String number = file.substring(numberBegin,tailBegin);
            String tail = file.substring(tailBegin, file.length());
            list.add(new Object[]{head, number, tail});
        }
        list.sort((a,b) -> {
            String h1 = ((String)a[0]).toUpperCase();
            String h2 = ((String)b[0]).toUpperCase();
            if(h1.equals(h2)) {
                Integer n1 = Integer.parseInt((String)a[1]);
                Integer n2 = Integer.parseInt((String)b[1]);
                return Integer.compare(n1, n2);
            }
            return h1.compareTo(h2);
        });
        
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            Object[] target = list.get(i);
            answer[i] = "" + target[0] +target[1] + target[2];
        }
        return answer;
    }
}