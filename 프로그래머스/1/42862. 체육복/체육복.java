class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] students = new int[n+2];
        for(int i=0; i<lost.length; i++) {
            students[lost[i]]--;
        }
        for(int i=0; i<reserve.length; i++) {
            students[reserve[i]]++;
        }
        
        for(int i=1; i<=n; i++) {
            if(students[i] == -1) {
                if(students[i-1] == 1) {
                    students[i] = 0;
                    students[i-1] = 0;
                } else if(students[i+1] == 1) {
                    students[i] = 0;
                    students[i+1] = 0;
                }
            }
        }
        
        for(int i=1; i<=n; i++) {
            System.out.print(students[i] + " ");
            if(students[i] >= 0) answer++;
        }
        return answer;
    }
}
