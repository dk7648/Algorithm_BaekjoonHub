import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        
        //주차시간 계산
        Map<String, String> enteredAt = new HashMap<>();
        Map<String, Integer> period = new HashMap<>();
        for(String record : records) {
            String[] input = record.split(" ");
            String time = input[0];
            String car = input[1];
            String type = input[2];
            if(type.equals("IN")) {
                enteredAt.put(car, time);
            } else if(type.equals("OUT")) {
                int usedTime = getPeriod(enteredAt.get(car), time);
                period.put(car, period.getOrDefault(car,0)+usedTime);
                enteredAt.remove(car);
            }
        }
        //남은 차량 계산
        for(String car : enteredAt.keySet()) {
            int usedTime = getPeriod(enteredAt.get(car), "23:59");
            period.put(car, period.getOrDefault(car,0)+usedTime);
        }
        
        //요금 정산
        Map<String, Integer> feeMap = new HashMap<>();
        for(String car : period.keySet()) {
            int time = period.get(car);
            int unitTime = Math.max((time-fees[0]+fees[2]-1)/fees[2], 0);
            
            int fee = fees[1] + unitTime * fees[3];
            feeMap.put(car, fee);
        }
        
        //정렬
        List<String> list = new ArrayList<>();
        list.addAll(feeMap.keySet());
        list.sort((a,b) -> a.compareTo(b));
        
        //결과
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            String car = list.get(i);
            answer[i] = feeMap.get(car);
        }
        
        return answer;
    }
    public int getPeriod(String in, String out) {
        int total1 = getTotalTime(in);
        int total2 = getTotalTime(out);
        
        return Math.abs(total1 - total2);
    }
    public int getTotalTime(String s) {
        String[] input = s.split(":");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        return h*60 + m;
    }
}